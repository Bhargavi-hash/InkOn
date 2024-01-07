package inkon.editors;

import java.util.EventObject;

import inkon.data.editors.*;
import inkon.editors.messages.*;

public class EditorInteractionEvent extends EditorEvent
{

    private InteractionMessage.Action action = null;
    
    public EditorInteractionEvent (EditorEditor              editor,
                                   InteractionMessage.Action action)
    {
        
        super (editor);
        
        this.action = action;
        
    }
        
    public InteractionMessage.Action getAction ()
    {
        
        return this.action;
        
    }
    
}
