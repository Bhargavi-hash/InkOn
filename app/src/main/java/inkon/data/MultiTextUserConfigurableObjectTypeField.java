package inkon.data;

import java.awt.Dimension;

import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;

import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.userobjects.*;

public class MultiTextUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    public MultiTextUserConfigurableObjectTypeField ()
    {

        super (Type.multitext);

    }

    protected MultiTextUserConfigurableObjectTypeField (Type type)
    {

        super (type);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectFieldViewEditHandler getViewEditHandler (UserConfigurableObject      obj,
                                                                          UserConfigurableObjectField field,
                                                                          inkon.ui.AbstractProjectViewer       viewer)
    {

        return new inkon.ui.userobjects.MultiTextUserConfigurableObjectFieldViewEditHandler (this,
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

        return new MultiTextUserConfigurableObjectFieldViewEditHandler (this,
                                                                        obj,
                                                                        field,
                                                                        viewer);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.MultiTextUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new MultiTextUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    public void setDisplayAsBullets (boolean v)
    {

        this.setDefinitionValue ("displayAsBullets", v);

    }

    public boolean isDisplayAsBullets ()
    {

        return this.getBooleanDefinitionValue ("displayAsBullets");

    }

    @Override
    public boolean isSearchable ()
    {

        return true;

    }

}
