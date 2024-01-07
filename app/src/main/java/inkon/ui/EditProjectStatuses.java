package inkon.ui;

import java.util.*;

import inkon.*;
import inkon.events.*;

import static inkon.LanguageStrings.*;
import static inkon.Environment.getUIString;

public class EditProjectStatuses extends TypesEditor<AbstractViewer, UserPropertyHandler>
{

    private java.util.List<String> prefix = new ArrayList<> ();

    public EditProjectStatuses (AbstractViewer viewer)
    {

        super (viewer);

        this.prefix = Arrays.asList (project,status,actions,manage);

    }

    @Override
    public UserPropertyHandler getTypesHandler ()
    {

        return Environment.getUserPropertyHandler (Constants.PROJECT_STATUSES_PROPERTY_NAME);

    }

    public void removePropertyChangedListener (PropertyChangedListener l)
    {

        this.getTypesHandler ().removePropertyChangedListener (l);

    }

    public void addPropertyChangedListener (PropertyChangedListener l)
    {

        this.getTypesHandler ().addPropertyChangedListener (l);

    }

    @Override
    public String getNewItemsTitle ()
    {

        return getUIString (this.prefix,_new,title);
        //return "New {Project} Statuses";

    }

    @Override
    public String getExistingItemsTitle ()
    {

        return getUIString (this.prefix,table,title);
        //return "Current {Project} Statuses";

    }

    @Override
    public String getNewItemsHelp ()
    {

        return getUIString (this.prefix,_new,text);
        //return "Enter the new statuses to add below, separate each status with a comma or semi-colon.";

    }

}
