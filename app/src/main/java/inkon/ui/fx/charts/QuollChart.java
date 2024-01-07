package inkon.ui.fx.charts;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.beans.property.*;

import inkon.*;
import inkon.ui.fx.*;

public interface QuollChart extends Stateful
{

    public StringProperty getTitle ();

    public String getType ();

    public Node getControls ()
                      throws GeneralException;

    public Node getChart ()
                   throws GeneralException;
/*
    public Region getDetails ()
                    throws GeneralException;
*/
}
