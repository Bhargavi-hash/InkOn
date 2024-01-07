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

public class LinkedToUserConfigurableObjectFieldViewEditHandler extends AbstractUserConfigurableObjectFieldViewEditHandler<LinkedToUserConfigurableObjectTypeField, String>
{

    private LinkedToPanel editPanel = null;
    private LinkedToPanel viewPanel = null;
    private IPropertyBinder binder = null;

    public LinkedToUserConfigurableObjectFieldViewEditHandler (LinkedToUserConfigurableObjectTypeField typeField,
                                                               UserConfigurableObject                  obj,
                                                               UserConfigurableObjectField             field,
                                                               IPropertyBinder                         binder,
                                                               AbstractProjectViewer                   viewer)
    {

        super (typeField,
               obj,
               field,
               viewer);

        this.binder = binder;

    }

    @Override
    public String getStyleClassName ()
    {

        return "linkedto";

    }

    @Override
    public void grabInputFocus ()
    {

    }

    @Override
    public void updateFieldFromInput ()
                               throws GeneralException
    {

        this.obj.setLinks (this.editPanel.getSelected ());

    }

    @Override
    public Set<Form.Item> getInputFormItems (String   initValue,
                                             Runnable formSave)
    {

        Set<Form.Item> items = new LinkedHashSet<> ();

        this.editPanel = new LinkedToPanel (obj,
                                            binder,
                                            viewer);
        this.editPanel.showEdit ();

        items.add (new Form.Item (this.typeField.formNameProperty (),
                                  this.editPanel));

        return items;

    }

    @Override
    public Set<StringProperty> getInputFormItemErrors ()
    {

        return null;

    }

    @Override
    public String getInputSaveValue ()
    {

        return null;

    }

    @Override
    public String stringToValue (String s)
    {

        return null;

    }

    @Override
    public String valueToString (String val)
    {

        return null;

    }

    @Override
    public Set<Form.Item> getViewFormItems (Runnable formSave)
    {

        Set<Form.Item> items = new LinkedHashSet<> ();

        this.viewPanel = new LinkedToPanel (this.obj,
                                            this.binder,
                                            this.viewer);
        this.viewPanel.showView ();

        items.add (new Form.Item (this.typeField.formNameProperty (),
                                  this.viewPanel));

        return items;

    }

}
