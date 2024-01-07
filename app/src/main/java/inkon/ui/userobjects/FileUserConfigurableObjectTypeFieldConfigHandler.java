package inkon.ui.userobjects;

import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;

import javax.swing.*;

import inkon.*;
import inkon.ui.*;
import inkon.ui.forms.*;
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
    public String getConfigurationDescription ()
    {
        
        Set<String> strs = new LinkedHashSet ();
        
        strs.add ("file");
        
        return Utils.joinStrings (strs,
                                  null);
        
    }
        
    public Set<String> getExtraFormItemErrors (UserConfigurableObjectType objType)
    {
        
        Set<String> errors = new LinkedHashSet ();
                                            
        return errors;
        
    }
    
    public Set<FormItem> getExtraFormItems ()
    {
     
        Set<FormItem> nitems = new LinkedHashSet ();
                            
        return nitems;
                                  
    }

}
