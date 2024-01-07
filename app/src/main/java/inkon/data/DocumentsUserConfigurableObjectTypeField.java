package inkon.data;

import java.util.*;

import inkon.ui.fx.*;
import inkon.ui.fx.userobjects.*;
import inkon.ui.fx.viewers.*;

public class DocumentsUserConfigurableObjectTypeField extends UserConfigurableObjectTypeField
{

    protected DocumentsUserConfigurableObjectTypeField (Type type)
    {

        super (type);

    }

    public DocumentsUserConfigurableObjectTypeField ()
    {

        super (Type.documents);

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
                                                                          IPropertyBinder             binder,
                                                                          AbstractProjectViewer       viewer)
    {

        return new DocumentsUserConfigurableObjectFieldViewEditHandler (this,
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

        return new DocumentsUserConfigurableObjectTypeFieldConfigHandler (this);

    }

}
