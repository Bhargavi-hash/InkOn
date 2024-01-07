package inkon.ui.fx.userobjects;

import java.util.*;

import javafx.beans.property.*;

import inkon.*;
import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.components.*;
import inkon.data.*;

import static inkon.LanguageStrings.*;
import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;

public class ObjectNameUserConfigurableObjectTypeFieldConfigHandler implements UserConfigurableObjectTypeFieldConfigHandler
{

    private ObjectNameUserConfigurableObjectTypeField field = null;

    public ObjectNameUserConfigurableObjectTypeFieldConfigHandler (ObjectNameUserConfigurableObjectTypeField field)
    {

        this.field = field;

    }

    public String getObjName ()
    {

        return this.field.getUserConfigurableObjectType ().getObjectTypeName ().toLowerCase ();

    }

    public String replaceObjName (String s)
    {

        return String.format (s,
                              this.getObjName ());

    }

    @Override
    public StringProperty getConfigurationDescription ()
    {

        return getUILanguageStringProperty (Arrays.asList (form,config,types,UserConfigurableObjectTypeField.Type.objectname.getType (),description),
                                            this.getObjName ());

    }

    @Override
    public boolean updateFromExtraFormItems ()
    {

        return true;

    }

    @Override
    public Set<StringProperty> getExtraFormItemErrors (UserConfigurableObjectType objType)
    {

        Set<StringProperty> errors = new LinkedHashSet<> ();

        return errors;

    }

    @Override
    public Set<Form.Item> getExtraFormItems ()
    {

        Set<Form.Item> nitems = new LinkedHashSet<> ();

        return nitems;

    }

}
