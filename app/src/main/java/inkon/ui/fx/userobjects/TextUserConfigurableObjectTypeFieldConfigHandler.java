package inkon.ui.fx.userobjects;

import java.util.*;

import javafx.beans.property.*;

import inkon.*;
import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.components.*;
import inkon.data.*;
import inkon.uistrings.UILanguageStringsManager;

import static inkon.LanguageStrings.*;
import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;

public class TextUserConfigurableObjectTypeFieldConfigHandler implements UserConfigurableObjectTypeFieldConfigHandler
{

    private TextUserConfigurableObjectTypeField field = null;
    private QuollCheckBox isOtherNames = null;

    public TextUserConfigurableObjectTypeFieldConfigHandler (TextUserConfigurableObjectTypeField field)
    {

        this.field = field;

        List<String> prefix = Arrays.asList (form,config,types,UserConfigurableObjectTypeField.Type.text.getType (),othernames);

        this.isOtherNames = QuollCheckBox.builder ()
            .label (getUILanguageStringProperty (Utils.newList (prefix,text),
                                                 this.field.getUserConfigurableObjectType ().getObjectTypeName ()))
            .tooltip (getUILanguageStringProperty (Utils.newList (prefix,tooltip),
                                                   this.field.getUserConfigurableObjectType ().getObjectTypeName ()))
            .build ();

    }

    public String getObjName ()
    {

        return this.field.getUserConfigurableObjectType ().getObjectTypeName ().toLowerCase ();

    }

    @Override
    public StringProperty getConfigurationDescription ()
    {

        List<String> prefix = Arrays.asList (form,config,types,UserConfigurableObjectTypeField.Type.text.getType ());

        StringProperty p = new SimpleStringProperty ();
        p.bind (UILanguageStringsManager.createStringBinding (() ->
        {

            Set<String> strs = new LinkedHashSet<> ();

            strs.add (getUILanguageStringProperty (Utils.newList (prefix,description)).getValue ());
            //"single line text");

            if (this.field.isNameField ())
            {

                strs.add (getUILanguageStringProperty (Utils.newList (prefix,othernames,description)).getValue ());
                                               //"is other names/aliases for the %s"));

            }

            String s = Utils.joinStrings (strs,
                                          null);

            return String.format (s,
                                  this.getObjName ());

        }));

        return p;

    }

    @Override
    public boolean updateFromExtraFormItems ()
    {

        this.field.setNameField (this.isOtherNames.isSelected ());

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

        this.isOtherNames.setSelected (this.field.isNameField ());

        nitems.add (new Form.Item (this.isOtherNames));

        return nitems;

    }

}
