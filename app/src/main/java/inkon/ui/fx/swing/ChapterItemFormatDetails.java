package inkon.ui.fx.swing;

import java.util.Set;

import java.awt.event.*;
import javax.swing.*;

import inkon.data.*;
import inkon.ui.panels.*;
import inkon.ui.fx.viewers.*;

public interface ChapterItemFormatDetails<E extends ChapterItem, V extends AbstractProjectViewer>
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
