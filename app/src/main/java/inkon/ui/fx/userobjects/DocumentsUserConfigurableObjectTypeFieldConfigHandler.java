package inkon.ui.fx.userobjects;

import java.time.*;
import java.util.*;

import javafx.beans.property.*;
import javafx.scene.control.*;

import inkon.*;
import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.components.*;
import inkon.data.*;
import inkon.uistrings.UILanguageStringsManager;

import static inkon.LanguageStrings.*;
import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;

public class DocumentsUserConfigurableObjectTypeFieldConfigHandler implements UserConfigurableObjectTypeFieldConfigHandler
{

    private DocumentsUserConfigurableObjectTypeField field = null;

    public DocumentsUserConfigurableObjectTypeFieldConfigHandler (DocumentsUserConfigurableObjectTypeField f)
    {

        this.field = f;

    }

    @Override
    public StringProperty getConfigurationDescription ()
    {

        return null;

    }

    @Override
    public boolean updateFromExtraFormItems ()
    {

        return true;

    }

    @Override
    public Set<StringProperty> getExtraFormItemErrors (UserConfigurableObjectType objType)
    {

        return new LinkedHashSet<> ();

    }

    @Override
    public Set<Form.Item> getExtraFormItems ()
    {

        return null;

    }

}
