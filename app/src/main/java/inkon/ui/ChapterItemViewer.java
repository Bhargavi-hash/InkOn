package inkon.ui;

import java.awt.Point;

import javax.swing.*;

import inkon.*;
import inkon.data.*;
import inkon.ui.components.QTextEditor;

public interface ChapterItemViewer<E extends AbstractViewer> extends PopupsSupported
{
    
    public E getViewer ();
    
    public int getIconColumnXOffset (ChapterItem c);
    
    public JScrollPane getScrollPane ();
    
    public Point getLastMousePosition ();
    
    public QTextEditor getEditor ();
    
    public IconColumn getIconColumn ();
    
    public ChapterItemTransferHandler getChapterItemTransferHandler ();
 
    public <T extends ChapterItem> void removeItem (T c);

    public <T extends ChapterItem> void addItem (T c)
                                          throws GeneralException;
                  
    public void highlightItemTextInEditor (ChapterItem c);
    
    public void removeItemHighlightTextFromEditor (ChapterItem c);
    
}