package inkon.data;

import java.util.*;

import java.math.*;

import inkon.*;
import inkon.ui.fx.*;
import inkon.ui.fx.userobjects.*;
import inkon.ui.fx.viewers.*;

public class NumberUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    public static final String MAX = "max";
    public static final String MIN = "min";

    public NumberUserConfigurableObjectTypeField ()
    {

        super (Type.number);

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

        return new inkon.ui.userobjects.NumberUserConfigurableObjectFieldViewEditHandler (this,
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

        return new NumberUserConfigurableObjectFieldViewEditHandler (this,
                                                                     obj,
                                                                     field,
                                                                     viewer);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.NumberUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new NumberUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    public Double getMinimum ()
                       throws GeneralException
    {

        return this.getDoubleDefinitionValue (MIN);

    }

    public void setMinimum (Double v)
    {

        this.setDefinitionValue (MIN,
                                 (v != null ? Environment.formatNumber (v) : null));

    }

    public Double getMaximum ()
                       throws GeneralException
    {

        return this.getDoubleDefinitionValue (MAX);

    }

    public void setMaximum (Double v)
    {

        this.setDefinitionValue (MAX,
                                 (v != null ? Environment.formatNumber (v) : null));

    }

}
