package inkon.editors.ui;

import java.net.*;

import java.security.*;

import java.text.*;

import java.util.*;
import java.util.function.*;

import javafx.scene.*;
import javafx.beans.property.*;

import inkon.*;

import inkon.data.*;
import inkon.data.editors.*;

import inkon.db.*;

import inkon.events.*;
import inkon.data.comparators.*;
import inkon.text.*;
import inkon.editors.ui.sidebars.*;
import inkon.editors.ui.panels.*;
import inkon.editors.*;
import inkon.editors.messages.*;
import inkon.editors.ui.*;
import inkon.ui.fx.*;
import inkon.ui.fx.components.*;
import inkon.uistrings.UILanguageStringsManager;

import static inkon.LanguageStrings.*;
import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;

public class ProjectCommentsViewer extends ProjectSentReceivedViewer<ProjectCommentsMessage>
{

    public ProjectCommentsViewer (Project                proj,
                                  ProjectCommentsMessage message)
    {

        super (proj,
               message);

    }

    /*
    public void switchToProjectComments (ProjectCommentsMessage pcm)
    {

        if (pcm == null)
        {

            throw new IllegalArgumentException ("Expected a project comments message");

        }

        this.message = pcm;

        this.initTitle ();

        ProjectSentReceivedSideBar sb = null;

        try
        {

            sb = this.getSideBar ();

            sb.init ();

        } catch (Exception e) {

            Environment.logError ("Unable to init new editor project comments side bar",
                                  e);

            UIUtils.showErrorMessage (this,
                                      "Unable to show comments, please contact Quoll Writer support for assistance.");

            // Need to close and reopen the project?

            return;

        }

        this.sideBar = sb;

        this.setMainSideBar (this.sideBar);

    }
    */

    @Override
    public Supplier<Set<Node>> getTitleHeaderControlsSupplier ()
	{

        return () ->
        {

            Set<Node> controls = new LinkedHashSet<> ();

            controls.add (QuollButton.builder ()
                .tooltip (editors,projectcomments,title,toolbar,buttons,openproject,tooltip)
                .iconName (StyleClassNames.OPEN)
                .buttonId ("open")
                .onAction (ev ->
                {

                    ProjectInfo proj = null;

                    try
                    {

                        proj = Environment.getProjectById (this.message.getForProjectId (),
                                                           this.message.isSentByMe () ? Project.EDITOR_PROJECT_TYPE : Project.NORMAL_PROJECT_TYPE);

                    } catch (Exception e) {

                        Environment.logError ("Unable to get project for: " +
                                              this.message.getForProjectId (),
                                              e);

                        ComponentUtils.showErrorMessage (this,
                                                         getUILanguageStringProperty (editors,LanguageStrings.project,actions,openproject,openerrors,general));
                                                  //"Unable to show {comments}, please contact Quoll Writer support for assistance.");

                        return;

                    }

                    try
                    {

                        Environment.openProject (proj);

                    } catch (Exception e) {

                        Environment.logError ("Unable to get project for: " +
                                              this.message.getForProjectId (),
                                              e);

                        ComponentUtils.showErrorMessage (this,
                                                         getUILanguageStringProperty (editors,LanguageStrings.project,actions,openproject,openerrors,general));
                                                  //"Unable to show {comments}, please contact Quoll Writer support for assistance.");

                        return;

                    }

                })
                .build ());

            controls.addAll (super.getTitleHeaderControlsSupplier ().get ());

            return controls;

        };

	}

    @Override
    public void init (State s)
               throws GeneralException
    {

        super.init (s);

        this.setMainSideBar (new ProjectCommentsSideBar (this,
                                                         this.message));

        // Show the first comment in the first chapter.
        this.viewObject (this.project.getBook (0).getChapters ().get (0).getNotes ().iterator ().next ());

    }

    @Override
    public String getStyleClassName ()
    {

        return StyleClassNames.COMMENTS;

    }

    @Override
    public StringProperty titleProperty ()
    {

        return UILanguageStringsManager.createStringPropertyWithBinding (() ->
        {

            String verName = "";

            if (this.getProject ().getProjectVersion () != null)
            {

                verName = this.getProject ().getProjectVersion ().getName ();

                if (verName != null)
                {

                    verName = getUILanguageStringProperty (editors,projectcomments,(this.message.isSentByMe () ? sent : received),viewertitleversionwrapper,
                                            //" (%s)",
                                                           verName).getValue ();

                }

            }

            return getUILanguageStringProperty (editors,projectcomments,(this.message.isSentByMe () ? sent : received),viewertitle,
                                //"{Comments} on%s: %s",
                                                verName,
                                                this.project.getName ()).getValue ();

        });

    }

}
