package inkon.ui.fx;

import javafx.scene.*;

import inkon.ui.fx.viewers.*;
import inkon.ui.fx.components.*;
import inkon.data.*;

public abstract class FindResultsBox<E extends AbstractViewer> implements IPropertyBinder
{

    protected E viewer = null;
    private IPropertyBinder binder = null;

    public FindResultsBox (E               pv,
                           IPropertyBinder binder)
    {

        this.viewer = pv;
        this.binder = binder;

    }

    public abstract void dispose ();

    public abstract Node getContent ();

    @Override
    public IPropertyBinder getBinder ()
    {

        return this.binder;

    }

}
