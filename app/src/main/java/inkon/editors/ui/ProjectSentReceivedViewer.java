package inkon.editors.ui;

import java.net.*;

import java.security.*;

import java.text.*;

import java.util.*;
import java.util.function.*;

import javafx.beans.property.*;
import javafx.scene.*;
import javafx.scene.control.*;

//import com.gentlyweb.properties.*;

import inkon.*;

import inkon.data.*;
import inkon.data.editors.*;

import inkon.db.*;

import inkon.events.*;
import inkon.data.comparators.*;
import inkon.text.*;
import inkon.editors.ui.sidebars.*;
import inkon.editors.ui.panels.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.*;
import inkon.ui.fx.panels.*;
import inkon.ui.fx.components.*;
import inkon.uistrings.UILanguageStringsManager;
import inkon.editors.*;
import inkon.editors.messages.*;
import inkon.editors.ui.*;

import static inkon.LanguageStrings.*;
import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;

public abstract class ProjectSentReceivedViewer<E extends EditorMessage> extends AbstractProjectViewer
{

    private EditorEditor editor = null;
    protected E message = null;

    public ProjectSentReceivedViewer (Project proj,
                                      E       message)
    {

        this.project = proj;
        this.message = message;
        this.getStyleClass ().add ("projectsentreceived");

        // TODO Set icon of header.

    }

    @Override
    public boolean addToAchievementsManager ()
    {

        return false;

    }

    @Override
    public void init (State s)
               throws GeneralException
    {

        super.init (s);

        this.viewObject (this.project.getBook (0).getChapters ().get (0));

    }

    @Override
    public void close (Runnable afterClose)
    {

        this.project = null;
        super.close (afterClose);

    }

    public E getMessage ()
    {

        return this.message;

    }

    @Override
    public Supplier<Set<Node>> getTitleHeaderControlsSupplier ()
	{

        return () ->
        {

            Set<Node> controls = new LinkedHashSet<> ();

            controls.add (this.getTitleHeaderControl (HeaderControl.contacts));
            controls.add (this.getTitleHeaderControl (HeaderControl.find));
            controls.add (this.getTitleHeaderControl (HeaderControl.close));

            return controls;

        };

	}

    @Override
    public void handleNewProject ()
    {

        throw new UnsupportedOperationException ("Not supported for viewing project comments.");

    }

    @Override
    public StringProperty titleProperty ()
    {

        return UILanguageStringsManager.createStringPropertyWithBinding (() ->
        {

            return getUILanguageStringProperty (Arrays.asList (editors,projectsent,viewertitle),
                                                this.project.getName ()).getValue ();

        },
        this.project.nameProperty ());

    }

    @Override
    public void handleOpenProject ()
    {

        throw new UnsupportedOperationException ("Not supported for viewing sent/received information.");

    }

	@Override
	public void saveProject ()
	{

        // Do nothing.

	}
/*
    public ChapterCommentsPanel getEditorForChapter (Chapter c)
    {

        for (QuollPanel qp : this.getAllQuollPanelsForObject (c))
        {

            if (qp instanceof FullScreenQuollPanel)
            {

                qp = ((FullScreenQuollPanel) qp).getChild ();

            }

            if (qp instanceof ChapterCommentsPanel)
            {

                return (ChapterCommentsPanel) qp;

            }

        }

        return null;

    }
*/
    /**
     * This is a top-level action so it can handle showing the user a message, it returns a boolean to indicate
     * whether the chapter has been opened for editing.
     */
     public void editChapter (final Chapter  c,
                              final Runnable doAfterView)
     {

         NamedObjectPanelContent p = this.getPanelForObject (c);

         if (p != null)
         {

             this.showPanel (p.getPanel ().getPanelId ());

             UIUtils.runLater (doAfterView);

             return;

         }

         try
         {

             p = new ChapterCommentsPanel (this,
                                           c);

             this.addPanel (p);

             this.editChapter (c,
                               doAfterView);

         } catch (Exception e) {

             Environment.logError ("Unable to edit chapter: " +
                                   c,
                                   e);

             ComponentUtils.showErrorMessage (this,
                                              getUILanguageStringProperty (editors,projectsent,actions,viewchapter,actionerror));

         }

     }

    @Override
    public void viewObject (final DataObject d,
                            final Runnable   doAfterView)
    {

        if (d instanceof Note)
        {

            final Note n = (Note) d;

            this.viewObject (n.getChapter (),
                             () ->
                             {

                                 ChapterCommentsPanel pc = (ChapterCommentsPanel) this.getEditorForChapter (n.getChapter ());

                                 if (pc.isReadyForUse ())
                                 {

                                     UIUtils.forceRunLater (() ->
                                     {

                                         pc.showItem (n,
                                                      false);

                                     });

                                } else {

                                    pc.readyForUseProperty ().addListener ((pr, oldv, nev) ->
                                    {

                                        UIUtils.forceRunLater (() ->
                                        {

                                            pc.showItem (n,
                                                         false);

                                        });

                                    });

                                }

                            });

            return;

        }

        if (d instanceof Chapter)
        {

            Chapter c = (Chapter) d;

            this.editChapter (c,
                              doAfterView);

            return;

        }

        // Record the error, then ignore.
        Environment.logError ("Unable to open object: " + d);

    }

    public Set<FindResultsBox> findText (String t)
    {

        Set<FindResultsBox> res = new LinkedHashSet<> ();

        FindResultsBox chres = this.findTextInChapters (t);

        if (chres != null)
        {

            res.add (chres);

        }

        Set<Note> notes = this.project.getNotesContaining (t);

        if (notes.size () > 0)
        {

            res.add (new NamedObjectFindResultsBox<Note> (getUILanguageStringProperty (objectnames,plural,Note.OBJECT_TYPE),
                                                          StyleClassNames.COMMENTS,
                                                          this,
                                                          notes));

        }

        return res;

    }

    @Override
    public Supplier<Set<MenuItem>> getSettingsMenuSupplier ()
    {

        final ProjectSentReceivedViewer _this = this;

        return () ->
        {

            Set<MenuItem> items = new LinkedHashSet<> ();

            List<String> prefix = Arrays.asList (editors,LanguageStrings.project,settingsmenu,LanguageStrings.items);

            items.add (QuollMenuItem.builder ()
                .label (Utils.newList (prefix,openproject))
                .iconName (StyleClassNames.OPEN)
                .onAction (ev ->
                {

                    _this.runCommand (CommandId.openproject);

                })
                .build ());

            items.add (QuollMenuItem.builder ()
                .label (Utils.newList (prefix,closeproject))
                .iconName (StyleClassNames.CLOSE)
                .onAction (ev ->
                {

                    _this.runCommand (CommandId.closeproject);

                })
                .build ());

            return items;

        };

    }

    @Override
    public void createActionLogEntry (NamedObject n,
                                      String      m)
    {

        // Do nothing.

    }

}
