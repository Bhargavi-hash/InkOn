package inkon.events;

import java.util.EventListener;

public interface SideBarListener extends EventListener
{
    
    public void sideBarShown (SideBarEvent ev);

    public void sideBarHidden (SideBarEvent ev);

}