package inkon.data;

import inkon.ui.fx.viewers.*;
import inkon.ui.fx.userobjects.*;

/**
 * Models a text user configurable object field.
 */
public class ObjectNameUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    public ObjectNameUserConfigurableObjectTypeField ()
    {

        super (Type.objectname);

    }

    @Override
    public boolean isSortable ()
    {

        return true;

    }

    @Override
    public boolean canDelete ()
    {

        return false;

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new ObjectNameUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public ObjectNameUserConfigurableObjectFieldViewEditHandler getViewEditHandler2 (UserConfigurableObject      obj,
                                                                           UserConfigurableObjectField field,
                                                                           IPropertyBinder             binder,
                                                                           AbstractProjectViewer       viewer)
    {

        return new ObjectNameUserConfigurableObjectFieldViewEditHandler (this,
                                                                         obj,
                                                                         field,
                                                                         viewer);

    }

    @Override
    // TODO Remove
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.ObjectNameUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    // TODO Remove
    public inkon.ui.userobjects.UserConfigurableObjectFieldViewEditHandler getViewEditHandler (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          inkon.ui.AbstractProjectViewer       viewer)
    {

        return new inkon.ui.userobjects.ObjectNameUserConfigurableObjectFieldViewEditHandler (this,
                                                                         obj,
                                                                         field,
                                                                         viewer);

    }

    @Override
    public boolean isSearchable ()
    {

        return true;

    }

    @Override
    public void setNameField (boolean v)
    {

        // Ignore.

    }

    @Override
    public boolean isNameField ()
    {

        return true;

    }

}
