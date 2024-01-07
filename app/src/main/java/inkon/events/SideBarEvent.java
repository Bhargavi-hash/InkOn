package inkon.events;

import java.util.EventObject;

import inkon.ui.sidebars.AbstractSideBar;
import inkon.ui.*;

public class SideBarEvent extends EventObject
{

    private AbstractSideBar sb = null;
    private AbstractProjectViewer viewer = null;
    
    public SideBarEvent (AbstractProjectViewer source,
                         AbstractSideBar       sb)
    {
        
        super (source);
        
        this.viewer = source;
        
        this.sb = sb;
        
    }

    public AbstractProjectViewer getViewer ()
    {
        
        return this.viewer;
        
    }
    
    public AbstractSideBar getSideBar ()
    {
        
        return this.sb;
        
    }
    
}