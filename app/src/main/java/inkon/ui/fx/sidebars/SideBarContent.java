package inkon.ui.fx.sidebars;

import javafx.scene.layout.*;
import javafx.beans.value.*;
import javafx.collections.*;

import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.components.*;
import inkon.data.IPropertyBinder;
import inkon.data.PropertyBinder;

/**
 * A base class for content that is suitable for display within a sidebar.
 */
public abstract class SideBarContent<E extends AbstractViewer> extends ViewerContent<E> implements Stateful, SideBarCreator, IPropertyBinder
{

    protected SideBar sidebar = null;
    private PropertyBinder binder = new PropertyBinder ();

    public SideBarContent (E viewer)
    {

        super (viewer);

    }

    @Override
    public State getState ()
    {

        return new State ();

    }

    @Override
    public IPropertyBinder getBinder ()
    {

        return this.binder;

    }

    public void dispose ()
    {

        this.binder.dispose ();

    }

    @Override
    public void init (State s)
    {

    }

    public SideBar getSideBar ()
    {

        if (this.sidebar == null)
        {

            this.sidebar = this.createSideBar ();

            this.sidebar.addEventHandler (SideBar.SideBarEvent.CLOSE_EVENT,
                                          ev ->
            {

                this.dispose ();

            });

        }

        return this.sidebar;

    }

}
