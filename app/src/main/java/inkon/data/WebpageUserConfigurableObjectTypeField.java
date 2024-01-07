package inkon.data;

import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.userobjects.*;

public class WebpageUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    public WebpageUserConfigurableObjectTypeField ()
    {

        super (Type.webpage);

    }

    @Override
    public boolean isSortable ()
    {

        return true;

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectFieldViewEditHandler getViewEditHandler (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          inkon.ui.AbstractProjectViewer       viewer)
    {

        return new inkon.ui.userobjects.WebpageUserConfigurableObjectFieldViewEditHandler (this,
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

        return new WebpageUserConfigurableObjectFieldViewEditHandler (this,
                                                                      obj,
                                                                      field,
                                                                      viewer);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.WebpageUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new WebpageUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public boolean isSearchable ()
    {

        return true;

    }

}
