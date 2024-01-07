package inkon.ui.fx;

import javafx.beans.property.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import inkon.*;
import inkon.ui.fx.components.*;
import inkon.data.IPropertyBinder;
import inkon.data.Scene;
import inkon.ui.fx.viewers.*;

public class SceneItemFormatter extends AbstractProjectItemFormatter<Scene>
{

    public SceneItemFormatter (ProjectViewer              viewer,
                               IPropertyBinder            binder,
                               inkon.data.Scene scene,
                               Runnable                   onNewPopupShown)
    {

        super (viewer,
               binder,
               scene,
               onNewPopupShown,
               null);

    }

    @Override
    public Node getContent ()
    {

        String desc = item.getDescription ().getMarkedUpText ();

        BasicHtmlTextFlow t = BasicHtmlTextFlow.builder ()
            .text (desc)
            .styleClassName (StyleClassNames.DESCRIPTION)
            .build ();

        return t;

    }

    public String getStyleClassName ()
    {

        return StyleClassNames.SCENE;

    }

    public StringProperty getPopupTitle ()
    {

        return Environment.getObjectTypeName (this.item);

    }

}
