package inkon.data;

import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import java.math.*;

import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.userobjects.*;

public class SelectUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    public static final String ITEMS = "items";
    public static final String ALLOWMULTI = "allowmulti";

    public SelectUserConfigurableObjectTypeField ()
    {

        super (Type.select);

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

        return new inkon.ui.userobjects.SelectUserConfigurableObjectFieldViewEditHandler (this,
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

        return new SelectUserConfigurableObjectFieldViewEditHandler (this,
                                                                     obj,
                                                                     field,
                                                                     viewer);

    }

    @Override
    public inkon.ui.userobjects.UserConfigurableObjectTypeFieldConfigHandler getConfigHandler ()
    {

        return new inkon.ui.userobjects.SelectUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    @Override
    public UserConfigurableObjectTypeFieldConfigHandler getConfigHandler2 ()
    {

        return new SelectUserConfigurableObjectTypeFieldConfigHandler (this);

    }

    public void setItems (Collection<String> its)
    {

        this.setDefinitionValue (ITEMS, new ArrayList<> (its));

    }

    public Collection<String> getItems ()
    {

        return (Collection<String>) this.getDefinitionValue (ITEMS);

    }

    @Override
    public boolean isSearchable ()
    {

        return true;

    }

    public boolean isAllowMulti ()
    {

        return this.getBooleanDefinitionValue (ALLOWMULTI);

    }

    public void setAllowMulti (boolean v)
    {

        this.setDefinitionValue (ALLOWMULTI, v);

    }

}
