package inkon.ui.fx;

import javafx.scene.*;
import javafx.scene.layout.*;

import inkon.ui.fx.viewers.*;

public class DebugConsole extends Region
{

    private AbstractViewer viewer = null;

    public DebugConsole (AbstractViewer viewer)
    {

        this.viewer = viewer;

    }

}
