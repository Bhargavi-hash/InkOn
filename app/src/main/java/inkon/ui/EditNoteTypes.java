package inkon.ui;

import javax.swing.*;

import inkon.*;

import static inkon.LanguageStrings.*;
import static inkon.Environment.getUIString;

public class EditNoteTypes extends TypesEditor<AbstractViewer, UserPropertyHandler>
{

    public EditNoteTypes (AbstractViewer pv)
    {

        super (pv);

    }

    @Override
    public UserPropertyHandler getTypesHandler ()
    {

        return Environment.getUserPropertyHandler (Constants.NOTE_TYPES_PROPERTY_NAME);

    }

    @Override
    public String getNewItemsHelp ()
    {

        return getUIString (notetypes,actions,manage,newtypes,text);
        //"Enter the new types to add below, separate each type with a comma or semi-colon.";

    }

    @Override
    public String getExistingItemsHelp ()
    {

        return getUIString (notetypes,actions,manage,table,text);
        //return "Note: removing a type will only remove it from the list of types to select when adding/editing a note.  You can also change the type name by editing the values, double click on a type to edit it.";

    }

    @Override
    public String getNewItemsTitle ()
    {

        return getUIString (notetypes,actions,manage,newtypes,title);
        //return "New Note Types";

    }

    @Override
    public String getExistingItemsTitle ()
    {

        return getUIString (notetypes,actions,manage,table,title);
        //return "Current Note Types";

    }

}
