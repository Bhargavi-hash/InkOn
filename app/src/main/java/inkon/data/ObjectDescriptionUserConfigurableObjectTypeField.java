package inkon.data;

import inkon.ui.fx.*;
import inkon.ui.fx.userobjects.*;
import inkon.ui.fx.viewers.*;

/**
 * Models a text user configurable object field.
 */
public class ObjectDescriptionUserConfigurableObjectTypeField extends MultiTextUserConfigurableObjectTypeField
{

    public ObjectDescriptionUserConfigurableObjectTypeField ()
    {

        super (Type.objectdesc);

        this.setDefinitionValue ("isObjectDesc", true);

    }

    @Override
    public boolean canDelete ()
    {

        return true;

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.ObjectDescriptionUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new ObjectDescriptionUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectFieldViewEditHandler getViewEditHandler (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          inkon.ui.AbstractProjectViewer       viewer)
    {

        return new inkon.ui.userobjects.ObjectDescriptionUserConfigurableObjectFieldViewEditHandler (this,
                                                                                obj,
                                                                                field,
                                                                                viewer);

    }

    @Override
    public ObjectDescriptionUserConfigurableObjectFieldViewEditHandler getViewEditHandler2 (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          IPropertyBinder             binder,
                                                                          AbstractProjectViewer       viewer)
    {

        return new ObjectDescriptionUserConfigurableObjectFieldViewEditHandler (this,
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

    }

    @Override
    public boolean isNameField ()
    {

        return false;

    }

}
