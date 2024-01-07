package inkon.ui.fx;

import javafx.beans.property.*;
import javafx.scene.Node;

import inkon.data.*;
import inkon.*;

public interface ChapterItemFormatter<E extends ChapterItem>
{

    String getStyleClassName ();
    StringProperty getPopupTitle ();
    Node format ();
    void deleteItem (E i);
    void editItem (E i);
    void saveItem (E i) throws GeneralException;

}
