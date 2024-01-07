package inkon.events;

import java.util.EventObject;

import inkon.ui.sidebars.AbstractSideBar;
import inkon.ui.*;

public class FullScreenEvent extends EventObject
{

    private AbstractProjectViewer viewer = null;
    
    public FullScreenEvent (AbstractProjectViewer source)
    {
        
        super (source);
        
        this.viewer = source;
        
    }

    public AbstractProjectViewer getViewer ()
    {
        
        return this.viewer;
        
    }
        
}