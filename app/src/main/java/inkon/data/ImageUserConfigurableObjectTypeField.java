package inkon.data;

import java.util.*;

import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.userobjects.*;

public class ImageUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    protected ImageUserConfigurableObjectTypeField (Type type)
    {

        super (type);

    }

    public ImageUserConfigurableObjectTypeField ()
    {

        super (Type.image);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectFieldViewEditHandler getViewEditHandler (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          inkon.ui.AbstractProjectViewer       viewer)
    {

        return new inkon.ui.userobjects.ImageUserConfigurableObjectFieldViewEditHandler (this,
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

        return new ImageUserConfigurableObjectFieldViewEditHandler (this,
                                                                    obj,
                                                                    field,
                                                                    viewer);

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new ImageUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.ImageUserConfigurableObjectTypeFieldConfigHandler (this);

    }

}
