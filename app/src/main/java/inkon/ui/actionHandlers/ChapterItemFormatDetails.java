package inkon.ui.actionHandlers;

import java.util.Set;

import java.awt.event.*;
import javax.swing.*;

import inkon.data.*;
import inkon.ui.*;
import inkon.ui.panels.*;
import inkon.ui.components.*;

public interface ChapterItemFormatDetails<E extends ChapterItem, V extends AbstractViewer>
{
    
    public abstract ActionListener getEditItemActionHandler (E                    item,
                                                             ChapterItemViewer<V> qep);

    public abstract ActionListener getDeleteItemActionHandler (E                    item,
                                                               ChapterItemViewer<V> qep,
                                                               boolean              showAtItem);

    public abstract Set<JComponent> getTools  (E                    item,
                                               ChapterItemViewer<V> qep);

    public abstract String getItemDescription (E item);

    public abstract String getIcon (E item);
    
    public abstract String getTitle (E item);    
    
}