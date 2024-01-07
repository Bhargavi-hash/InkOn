package inkon.ui.panels;

import java.awt.Component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.event.*;

import java.io.*;
import java.net.*;
import java.beans.*;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.sound.sampled.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;
import javax.swing.filechooser.*;

import com.gentlyweb.properties.*;

import inkon.data.*;
import inkon.*;
import inkon.events.*;
import inkon.ui.*;
import inkon.ui.renderers.*;
import inkon.ui.events.*;
import inkon.ui.components.Header;
import inkon.ui.components.ItemAdapter;
import inkon.ui.components.ActionAdapter;
import inkon.ui.components.QPopup;
import inkon.ui.components.ChangeAdapter;
import inkon.ui.components.ImagePanel;
import inkon.ui.components.Accordion;
import inkon.achievements.*;
import inkon.editors.*;
import inkon.data.editors.*;

import inkon.editors.messages.*;
import java.util.Date;
import inkon.editors.ui.*;

public class OptionsPanel extends QuollPanel<AbstractViewer>
{

    public static final String PANEL_ID = "options";

    private Accordion accordion = null;
    private JCheckBox sendErrorsToSupport = null;

    private Options options = null;

    public OptionsPanel (AbstractViewer     viewer,
                         Options.Section... sectIds)
                  throws GeneralException
    {

        super (viewer);

        this.options = new Options (viewer,
                                    sectIds);

    }

    public void showSection (String name)
    {

        this.showSection (Options.Section.valueOf (name));

    }

    public void showSection (Options.Section name)
    {

        this.options.showSection (name);

    }

    public void init ()
    {

        this.options.init ();

        this.add (this.options);

    }

    private void setContentBorder (JComponent box)
    {

        box.setBorder (UIUtils.createPadding (7, 0, 10, 0));

    }

    public void fillPopupMenu (MouseEvent ev,
                               JPopupMenu popup)
    {

    }

    public List<Component> getTopLevelComponents ()
    {

        return null;

    }

    public <T extends NamedObject> void refresh (T n)
    {


    }

    private JButton createTestButton ()
    {

        java.util.List<String> prefix = new ArrayList<> ();
        prefix.add (LanguageStrings.options);
        prefix.add (LanguageStrings.toolbar);
        prefix.add (LanguageStrings.buttons);
        prefix.add (LanguageStrings.test);
        prefix.add (LanguageStrings.tooltip);

        final OptionsPanel _this = this;

        return UIUtils.createToolBarButton (Constants.OPTIONS_ICON_NAME,
                                            Environment.getUIString (prefix),
                                                //"This is just a test item so you can see how the toolbar looks when you change it's location."),
                                                 null,
                                                 new ActionAdapter ()
        {

            public void actionPerformed (ActionEvent ev)
            {

                UIUtils.showMessage (_this,
                                     Environment.getUIString (LanguageStrings.options,
                                                              LanguageStrings.testboolbarbuttonmessage));
                                     //"This button is here as a test so you can see what the toolbar looks like when you move it.");

            }

        });

    }

    public void fillToolBar (JToolBar toolBar,
                             boolean  fullScreen)
    {

        toolBar.add (this.createTestButton ());
        toolBar.add (this.createTestButton ());
        toolBar.add (this.createTestButton ());

    }

    public boolean saveUnsavedChanges ()
                                throws Exception
    {

        return true;

    }

    public String getPanelId ()
    {

        return OptionsPanel.PANEL_ID;

    }

    public void setState (final Map<String, String> s,
                          boolean                   hasFocus)
    {

        final OptionsPanel _this = this;

        this.options.setState (s);

        this.setReadyForUse (true);

    }

    public void getState (Map<String, Object> m)
    {

        this.options.getState (m);

    }

    @Override
    public String getTitle ()
    {

        return Environment.getUIString (LanguageStrings.options,
                                        LanguageStrings.title);
                                        //"Options";

    }

    @Override
    public ImageIcon getIcon (int type)
    {

        return Environment.getIcon (Constants.OPTIONS_ICON_NAME,
                                    type);

    }

    @Override
    public void close ()
    {


    }
}
