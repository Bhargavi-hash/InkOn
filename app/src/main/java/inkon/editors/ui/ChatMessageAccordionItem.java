package inkon.editors.ui;

import java.util.*;
import javafx.scene.*;

import inkon.data.*;
import inkon.data.editors.*;
import inkon.*;
import inkon.editors.*;
import inkon.events.*;
import inkon.editors.messages.*;
import inkon.ui.fx.viewers.*;

public class ChatMessageAccordionItem extends MessageAccordionItem<EditorChatMessage>
{

    public ChatMessageAccordionItem (AbstractViewer         pv,
                                     Date                   d,
                                     Set<EditorChatMessage> messages)
    {

        super (pv,
               d,
               messages);

    }

    @Override
    public Node getMessageBox (EditorChatMessage m)
    {

        ChatMessageBox cmb = new ChatMessageBox (m,
                                                 this.viewer);

        return cmb;

    }

}
