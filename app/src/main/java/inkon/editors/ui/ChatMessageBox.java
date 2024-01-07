package inkon.editors.ui;

import java.awt.image.*;
import java.util.*;

import javafx.beans.property.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.embed.swing.*;
import javafx.scene.image.*;

import inkon.*;
import inkon.data.*;
import inkon.data.editors.*;
import inkon.editors.messages.*;
import inkon.editors.*;
import inkon.ui.fx.components.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.*;
import inkon.uistrings.UILanguageStringsManager;

import static inkon.LanguageStrings.*;
import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;

public class ChatMessageBox extends MessageBox<EditorChatMessage>
{

    public ChatMessageBox (EditorChatMessage mess,
                           AbstractViewer    viewer)
    {

        super (mess,
               viewer);

        this.managedProperty ().bind (this.visibleProperty ());
        this.getStyleClass ().add (StyleClassNames.CHATMESSAGE);

        HBox b = new HBox ();

        this.getChildren ().add (b);

        QuollTextView messText = QuollTextView.builder ()
            .text (this.message.getMessage ())
            .inViewer (this.viewer)
            .build ();
        HBox.setHgrow (messText,
                       Priority.ALWAYS);

        if (this.message.isSentByMe ())
        {

            ObjectProperty<Image> av = EditorsEnvironment.getUserAccount ().avatarProperty ();
/*
TODO Remove? Don't think its needed.
            if (av != null)
            {

                b.getChildren ().add (new ImageView (SwingFXUtils.toFXImage (EditorsEnvironment.getUserAccount ().getAvatar (),
                                                                             null)));

            }
*/
            b.getChildren ().add (messText);
            messText.maxWidthProperty ().bind (b.widthProperty ());
            messText.prefWidthProperty ().bind (b.widthProperty ());

            Node nav = this.createAvatar (av,
                                          (av == null ? getUILanguageStringProperty (editors,editor,view,chatmessages,sentbyme) : null),
                                          this.message.getWhen ());
            nav.getStyleClass ().add (StyleClassNames.USER);

            b.getChildren ().add (nav);

        } else {

            ObjectProperty<Image> av = this.message.getEditor ().mainAvatarProperty ();
/*
            if (av == null)
            {

                av = Environment.getNoEditorAvatarImage ();

            }
*/
            Node nav = this.createAvatar (av,
                                          null,
                                          this.message.getWhen ());
            nav.getStyleClass ().add (StyleClassNames.OTHER);

            b.getChildren ().add (nav);
            b.getChildren ().add (messText);

        }

    }

    public boolean isAutoDealtWith ()
    {

        return true;

    }

    private Node createAvatar (ObjectProperty<Image> im,
                               StringProperty        message,
                               Date                  when)
    {

        VBox b = new VBox ();

        IconBox ib = IconBox.builder ()
            .image (im)
            .styleClassName ("avatar-box")
            .onImagePresent (bb ->
            {

                bb.pseudoClassStateChanged (StyleClassNames.NOAVATAR_PSEUDO_CLASS, false);

            })
            .onNoImage (bb ->
            {

                bb.pseudoClassStateChanged (StyleClassNames.NOAVATAR_PSEUDO_CLASS, true);

            })
            .build ();

        b.getChildren ().add (ib);

        if (message != null)
        {

            b.getChildren ().add (QuollLabel.builder ()
                .label (message)
                .build ());

        }

        if (when != null)
        {

            b.getChildren ().add (QuollLabel.builder ()
                .label (UILanguageStringsManager.createStringPropertyWithBinding (() ->
                {

                    return Environment.formatTime (when);

                }))
                .build ());

        }

        return b;

    }

}
