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

public class WebpageUserConfigurableObjectTypeFieldConfigHandler implements UserConfigurableObjectTypeFieldConfigHandler
{

    private WebpageUserConfigurableObjectTypeField field = null;

    public WebpageUserConfigurableObjectTypeFieldConfigHandler (WebpageUserConfigurableObjectTypeField f)
    {

        this.field = f;

    }

    @Override
    public StringProperty getConfigurationDescription ()
    {

        return getUILanguageStringProperty (form,config,types,webpage,description);
        //"web page");

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
