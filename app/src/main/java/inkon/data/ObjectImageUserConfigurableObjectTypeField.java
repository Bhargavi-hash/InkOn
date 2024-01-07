package inkon.data;

import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;

import javax.swing.*;

import inkon.ui.fx.*;
import inkon.ui.fx.userobjects.*;
import inkon.ui.fx.viewers.*;

public class ObjectImageUserConfigurableObjectTypeField extends ImageUserConfigurableObjectTypeField
{

    public ObjectImageUserConfigurableObjectTypeField ()
    {

        super (Type.objectimage);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectFieldViewEditHandler getViewEditHandler (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          inkon.ui.AbstractProjectViewer       viewer)
    {

        return new inkon.ui.userobjects.ObjectImageUserConfigurableObjectFieldViewEditHandler (this,
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

        return new ObjectImageUserConfigurableObjectFieldViewEditHandler (this,
                                                                          obj,
                                                                          field,
                                                                          viewer);

    }

    public boolean isObjectImage ()
    {

        return true;

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.ObjectImageUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new ObjectImageUserConfigurableObjectTypeFieldConfigHandler (this);

    }

}
