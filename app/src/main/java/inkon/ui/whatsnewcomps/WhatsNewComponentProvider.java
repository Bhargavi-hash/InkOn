package inkon.ui.whatsnewcomps;

import javax.swing.*;

import inkon.ui.*;

public interface WhatsNewComponentProvider
{
    
    public JComponent getComponent (AbstractViewer pv,
                                    String         id);    
    
}