package inkon.ui;

import javax.swing.*;

import inkon.events.*;
import inkon.ui.sidebars.*;

public interface SideBarsSupported
{

    public JPopupMenu getShowOtherSideBarsPopupSelector ();

    public int getActiveSideBarCount ();
    
    public AbstractSideBar getActiveOtherSideBar ();
    
    public void addSideBarListener (SideBarListener l);
    
    public void removeSideBarListener (SideBarListener l);
    
    public void closeSideBar ();

}
