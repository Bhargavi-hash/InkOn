package inkon.ui.fx.userobjects;

import java.util.*;

import javafx.beans.property.*;

import inkon.*;
import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.components.*;
import inkon.data.*;

public class FileUserConfigurableObjectTypeFieldConfigHandler implements UserConfigurableObjectTypeFieldConfigHandler
{

    private FileUserConfigurableObjectTypeField field = null;

    public FileUserConfigurableObjectTypeFieldConfigHandler (FileUserConfigurableObjectTypeField f)
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

        return new SimpleStringProperty ("file");

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
