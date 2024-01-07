package inkon.editors.ui;

import java.util.*;
import java.util.concurrent.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

import inkon.*;
import inkon.data.*;
import inkon.events.*;
import inkon.editors.messages.*;
import inkon.editors.*;
import inkon.ui.fx.*;
import inkon.ui.fx.components.*;
import inkon.ui.fx.viewers.*;

import static inkon.LanguageStrings.*;
import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;

public abstract class MessageBox<E extends EditorMessage> extends VBox implements EditorMessageListener
{

    protected AbstractViewer viewer = null;
    protected E message = null;
    protected boolean showAttentionBorder = true;
    private PropertyChangedListener updateListener = null;
    private AbstractViewer childViewer = null;
    private ScheduledFuture updateAttention = null;
    protected IPropertyBinder binder = null;

    public MessageBox (E              mess,
                       AbstractViewer viewer)
    {

        this.binder = new PropertyBinder ();
        this.message = mess;
        this.viewer = viewer;

        // TODO ADD SCENE LISTENER

        this.getStyleClass ().add (StyleClassNames.MESSAGE);

        this.binder.addChangeListener (this.message.dealtWithProperty (),
                                       (pr, oldv, newv) ->
        {

            this.update ();

            this.pseudoClassStateChanged (StyleClassNames.ATTENTIONREQUIRED_PSEUDO_CLASS, !newv && this.showAttentionBorder);

            UIUtils.setTooltip (this,
                                getUILanguageStringProperty (Arrays.asList (editors,messages,view,tooltip,(this.message.isSentByMe () ? sent : received)),
                                                        //"%s %s",
                                                        //this.message.isSentByMe () ? "Sent" : "Received",
                                                             Environment.formatDateTime (this.message.getWhen ())));

        });

        this.addEventHandler (MouseEvent.MOUSE_ENTERED,
                              ev ->
        {

            if (this.updateAttention != null)
            {

                this.updateAttention.cancel (true);

            }

        });

        this.addEventHandler (MouseEvent.MOUSE_EXITED,
                              ev ->
        {

            if ((!this.message.isDealtWith ())
                &&
                (this.isAutoDealtWith ())
               )
            {

                this.updateAttention = Environment.schedule (() ->
                {

                    this.message.setDealtWith (true);

                    try
                    {

                        EditorsEnvironment.updateMessage (this.message);

                    } catch (Exception e) {

                        Environment.logError ("Unable to update message: " +
                                              this.message,
                                              e);

                    }

                },
                750,
                -1);

            }

        });

        this.setOnContextMenuRequested (ev ->
        {

            if (this.getProperties ().get ("context-menu") != null)
            {

                ((ContextMenu) this.getProperties ().get ("context-menu")).hide ();

            }

            if (!this.message.isSentByMe ())
            {

                ContextMenu m = new ContextMenu ();

                m.getItems ().add (QuollMenuItem.builder ()
                    .label (editors,messages,report,popupmenu,items,report)
                    .iconName (StyleClassNames.REPORTMESSAGE)
                    .onAction (eev ->
                    {

                        EditorsUIUtils.showReportMessage (this,
                                                          this.viewer,
                                                          this.binder);

                    })
                    .build ());

                m.show (this, ev.getScreenX (), ev.getScreenY ());

                this.getProperties ().put ("context-menu", m);

                ev.consume ();

            }

        });

        this.update ();

    }

    private void update ()
    {

        this.pseudoClassStateChanged (StyleClassNames.ATTENTIONREQUIRED_PSEUDO_CLASS, !this.message.isDealtWith () && this.showAttentionBorder);

        if ((!this.message.isDealtWith ())
            &&
            (this.showAttentionBorder)
           )
        {

            UIUtils.setTooltip (this,
                                getUILanguageStringProperty (editors,messages,view,attention,tooltip));//"This message needs your attention!");

        } else {

            UIUtils.setTooltip (this,
                                    getUILanguageStringProperty (Arrays.asList (editors,messages,view,tooltip,(this.message.isSentByMe () ? sent : received)),
                                                        //"%s %s",
                                                        //this.message.isSentByMe () ? "Sent" : "Received",
                                                                 Environment.formatDateTime (this.message.getWhen ())));

        }

    }

    public abstract boolean isAutoDealtWith ();

    public AbstractViewer getChildViewer ()
    {

        return this.childViewer;

    }

    public void setChildViewer (AbstractViewer v)
    {

        this.childViewer = v;

    }

/*
    @Override
    public Component add (Component c)
    {

        if (c instanceof JLayer)
        {

            return super.add (c);

        }

        return this.content.add (c);

    }
*/
    public void setShowAttentionBorder (boolean v)
    {

        this.showAttentionBorder = v;

        this.update ();

    }

    public boolean isShowAttentionBorder ()
    {

        return this.showAttentionBorder;

    }

    public EditorMessage getMessage ()
    {

        return this.message;

    }

    public boolean isDealtWith ()
    {

        return this.message.isDealtWith ();

    }

    public String getOpenMessageLink (EditorMessage m,
                                      String        link)
    {

        return String.format ("<a href='%s:%s'>%s</a>",
                              Constants.OPENEDITORMESSAGE_PROTOCOL,
                              m.getKey (),
                              link);

    }

    @Override
    /**
     * Listens for message events relating to the underlying message this box is displaying.
     * If the event is for our message and the message has been changed then {@link #update()} is called.
     *
     * @param ev The event.
     */
    public void handleMessage (EditorMessageEvent ev)
    {

        // Is this message for us?
        if ((ev.getMessage ().equals (this.message))
            &&
            (ev.getType () == EditorMessageEvent.MESSAGE_CHANGED)
           )
        {

            this.update ();

        }

    }
/*
    protected JComponent getMessageQuoteComponent (String message)
    {

        Box b = new Box (BoxLayout.X_AXIS);

        ImagePanel ip = new ImagePanel (Environment.getIcon (Constants.MESSAGE_ICON_NAME,
                                                             Constants.ICON_POPUP),
                                        null);

        ip.setAlignmentY (Component.TOP_ALIGNMENT);

        //b.add (ip);
        //b.add (Box.createHorizontalStrut (5));

        JComponent t = UIUtils.createHelpTextPane (message,
                                                   this.viewer);
        t.setAlignmentY (Component.TOP_ALIGNMENT);

        t.setBorder (null);
        t.setOpaque (false);

        b.add (t);

        b.setAlignmentX (Component.LEFT_ALIGNMENT);

        return b;

    }
*/
/*
    protected JComponent getMessageComponent (String message,
                                              String iconName)
    {

        Box b = new Box (BoxLayout.X_AXIS);

        if (iconName != null)
        {

            ImagePanel ip = new ImagePanel (Environment.getIcon (iconName,
                                                                 Constants.ICON_EDITOR_MESSAGE),
                                            null);

            ip.setAlignmentY (Component.TOP_ALIGNMENT);

            b.add (ip);
            b.add (Box.createHorizontalStrut (5));

        }

        JComponent t = UIUtils.createHelpTextPane (message,
                                                   this.viewer);
        t.setAlignmentY (Component.TOP_ALIGNMENT);

        t.setBorder (null);
        t.setOpaque (false);

        b.add (t);

        b.setAlignmentX (Component.LEFT_ALIGNMENT);

        return b;

    }
*/
}
