package inkon.ui.userobjects;

import javax.swing.*;

import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;

import inkon.ui.forms.*;
import inkon.data.*;

public interface UserConfigurableObjectTypeFieldConfigHandler
{
    
    public Set<FormItem> getExtraFormItems ();
    
    public boolean updateFromExtraFormItems ();
    
    public Set<String> getExtraFormItemErrors (UserConfigurableObjectType objType);
    
    public String getConfigurationDescription ();
        
}