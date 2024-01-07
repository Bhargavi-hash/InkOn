package inkon.ui.fx.swing;

import javax.swing.*;

import inkon.*;
import inkon.data.*;
import inkon.ui.fx.viewers.*;

public interface ChapterItemViewPopupProvider<V extends AbstractProjectViewer>
{

    public QPopup getViewPopup (ChapterItem          it,
                                ChapterItemViewer<V> panel)
                         throws GeneralException;

}
