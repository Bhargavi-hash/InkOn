package inkon.ui.fx;

import javafx.scene.*;

import inkon.ui.fx.viewers.*;

public interface WhatsNewNodeProvider
{

    public Node getNode (AbstractViewer pv,
                         String         id);

}
