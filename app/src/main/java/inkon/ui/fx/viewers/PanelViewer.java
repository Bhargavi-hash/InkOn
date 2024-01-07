package inkon.ui.fx.viewers;

import javafx.beans.property.*;
import javafx.event.*;

import inkon.ui.fx.components.*;

public interface PanelViewer
{

    Panel getCurrentPanel ();

    ObjectProperty<Panel> currentPanelProperty ();

    <T extends Event> void addEventHandler (EventType<T>            type,
                                            EventHandler<? super T> handler);

}
