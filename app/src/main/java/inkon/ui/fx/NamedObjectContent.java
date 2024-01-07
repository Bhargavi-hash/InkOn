package inkon.ui.fx;

import javafx.scene.layout.*;

import inkon.data.*;
import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;

/**
 A base class for content that is used to display named object content and thus by definition is also suitable for a viewer.
 */
public abstract class NamedObjectContent<E extends AbstractViewer, O extends NamedObject> extends ViewerContent<E>
{

    protected O object = null;

    public NamedObjectContent (E viewer,
                               O object)
    {

        super (viewer);

        this.object = object;

    }

    public O getObject ()
    {

        return this.object;

    }

}
