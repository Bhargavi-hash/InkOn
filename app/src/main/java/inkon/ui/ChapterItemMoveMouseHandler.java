package inkon.ui;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.*;

import inkon.*;
import inkon.data.*;
import inkon.ui.panels.*;
import inkon.ui.components.ImagePanel;
import inkon.ui.components.QTextEditor;

public class ChapterItemMoveMouseHandler extends ChapterItemMoveHandler
{
    
    public ChapterItemMoveMouseHandler (final ChapterItem item,
                                        final IconColumn  ic)
    {
        
        super (ic);
                
        final ChapterItemMoveMouseHandler _this = this;
        
        MouseAdapter m = new MouseAdapter ()
        {
            
            private boolean dragInProgress = false;
        
            public void mousePressed (MouseEvent ev)
            {
                
                _this.setItem (item);
                                        
            }
            
            public void mouseDragged (MouseEvent ev)
            {
                
                if (!this.dragInProgress)
                {
                    
                    _this.startDrag ();
                    
                    this.dragInProgress = true;
                    
                }

                _this.doDrag ();
                                                  
            }
            
            public void mouseReleased (MouseEvent ev)
            {
                        
                if (!this.dragInProgress)
                {
                    
                    return;                    
                        
                }
                
                this.dragInProgress = false;

                _this.dragFinished ();
                
            }
            
        };
        
        ImagePanel im = ic.getImagePanel (item);
        
        im.addMouseListener (m);
        im.addMouseMotionListener (m);        
        
    }    
    
}