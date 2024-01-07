package inkon.ui;

import javax.swing.*;

import inkon.*;
import inkon.data.*;
import inkon.ui.components.QPopup;

public interface ChapterItemViewPopupProvider<V extends AbstractViewer>
{
    
    public QPopup getViewPopup (ChapterItem          it,
                                ChapterItemViewer<V> panel)
                         throws GeneralException;
    
}