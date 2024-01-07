package inkon.events;

import java.util.EventObject;

import inkon.ui.*;
import inkon.ui.panels.*;
import inkon.data.*;

public class MainPanelEvent extends EventObject
{

    private QuollPanel panel = null;

    public MainPanelEvent (Object     source,
                           QuollPanel panel)
    {
        
        super (source);
        
        this.panel = panel;
        
    }

    public QuollPanel getPanel ()
    {
        
        return this.panel;
        
    }
    
    public DataObject getForObject ()
    {
        
        if (this.panel instanceof ProjectObjectQuollPanel)
        {
            
            ProjectObjectQuollPanel p = (ProjectObjectQuollPanel) this.panel;
            
            return p.getForObject ();
            
        }
        
        return null;
        
    }
    
}