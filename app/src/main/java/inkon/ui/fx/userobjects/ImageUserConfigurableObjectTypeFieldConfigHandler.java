package inkon.ui.fx.userobjects;

import java.util.*;

import javafx.beans.property.*;

import inkon.ui.fx.*;
import inkon.ui.fx.components.*;
import inkon.ui.fx.viewers.*;
import inkon.data.*;

public class ImageUserConfigurableObjectTypeFieldConfigHandler implements UserConfigurableObjectTypeFieldConfigHandler
{

    private ImageUserConfigurableObjectTypeField field = null;

    public ImageUserConfigurableObjectTypeFieldConfigHandler (ImageUserConfigurableObjectTypeField f)
    {

        this.field = f;

    }

    @Override
    public boolean updateFromExtraFormItems ()
    {

        return true;

    }

    @Override
    public StringProperty getConfigurationDescription ()
    {

        return new SimpleStringProperty ("image");

    }

    public Set<StringProperty> getExtraFormItemErrors (UserConfigurableObjectType objType)
    {

        Set<StringProperty> errors = new LinkedHashSet<> ();

        return errors;

    }

    public Set<Form.Item> getExtraFormItems ()
    {

        Set<Form.Item> nitems = new LinkedHashSet<> ();

        return nitems;

    }

}
