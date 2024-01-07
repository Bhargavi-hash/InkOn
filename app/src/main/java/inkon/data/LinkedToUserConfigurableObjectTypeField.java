package inkon.data;

import java.util.*;

import inkon.ui.fx.viewers.*;
import inkon.ui.fx.*;
import inkon.ui.fx.userobjects.*;

public class LinkedToUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    protected LinkedToUserConfigurableObjectTypeField (Type type)
    {

        super (type);

    }

    public LinkedToUserConfigurableObjectTypeField ()
    {

        super (Type.linkedto);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectFieldViewEditHandler getViewEditHandler (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          inkon.ui.AbstractProjectViewer       viewer)
    {

        return null;

    }

    @Override
    public UserConfigurableObjectFieldViewEditHandler getViewEditHandler2 (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                           IPropertyBinder            binder,
                                                                          AbstractProjectViewer       viewer)
    {

        return new LinkedToUserConfigurableObjectFieldViewEditHandler (this,
                                                                       obj,
                                                                       field,
                                                                       binder,
                                                                       viewer);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return null;

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new LinkedToUserConfigurableObjectTypeFieldConfigHandler (this);

    }

}
