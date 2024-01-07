package inkon.ui.actionHandlers;

import java.awt.Point;

import inkon.*;
import inkon.ui.*;
import static inkon.LanguageStrings.*;
import static inkon.Environment.getUIString;

public class AddNewNoteTypeActionHandler extends TextInputActionHandler
{

    public AddNewNoteTypeActionHandler (AbstractProjectViewer pv)
    {

        super (pv);

    }

    public String getIcon ()
    {

        return Constants.ADD_ICON_NAME;

    }

    public String getTitle ()
    {

        return getUIString (notetypes,actions,newnotetype,title);
        //"Add New {Note} Type";

    }

    public String getHelp ()
    {

        return getUIString (notetypes,actions,newnotetype,text);
        //"Enter the new {note} type below.";

    }

    public String getConfirmButtonLabel ()
    {

        return getUIString (notetypes,actions,newnotetype,add);
        //"Add";

    }

    public String getInitialValue ()
    {

        return null;

    }

    public String isValid (String v)
    {

        if ((v == null)
            ||
            (v.trim ().length () == 0)
           )
        {

            return getUIString (notetypes,actions,newnotetype,errors,novalue);
            //"Please enter a name.";

        }

        if (Environment.getUserPropertyHandler (Constants.NOTE_TYPES_PROPERTY_NAME).hasType (v))
        {

            return String.format (getUIString (notetypes,actions,newnotetype,errors,valueexists),
                                  v);
            //"A type called: " + v + " already exists.";

        }

        return null;

    }

    public boolean onConfirm (String v)
                              throws Exception
    {

        Environment.getUserPropertyHandler (Constants.NOTE_TYPES_PROPERTY_NAME).addType (v,
                                                                                         true);

        return true;

    }

    public boolean onCancel ()
                             throws Exception
    {

        return true;

    }

    public Point getShowAt ()
    {

        return null;

    }

}
