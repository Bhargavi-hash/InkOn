package inkon.data;

import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.userobjects.*;

/**
 * Models a text user configurable object field.
 */
public class TextUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    public TextUserConfigurableObjectTypeField ()
    {

        super (Type.text);

    }

    @Override
    public boolean isSortable ()
    {

        return true;

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.TextUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new TextUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectFieldViewEditHandler getViewEditHandler (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          inkon.ui.AbstractProjectViewer       viewer)
    {

        return new inkon.ui.userobjects.TextUserConfigurableObjectFieldViewEditHandler (this,
                                                                   obj,
                                                                   field,
                                                                   viewer);

    }

    @Override
    public UserConfigurableObjectFieldViewEditHandler getViewEditHandler2 (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          IPropertyBinder             binder,
                                                                          AbstractProjectViewer       viewer)
    {

        return new TextUserConfigurableObjectFieldViewEditHandler (this,
                                                                   obj,
                                                                   field,
                                                                   viewer);

    }

    @Override
    public boolean isSearchable ()
    {

        return true;

    }

}
