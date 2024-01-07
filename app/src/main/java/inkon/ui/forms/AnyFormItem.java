package inkon.ui.forms;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.*;

import inkon.*;
import inkon.ui.*;
import inkon.text.*;

public class AnyFormItem extends FormItem<String>
{
    
    private JComponent component = null;
        
    public AnyFormItem (Object     label,
                        JComponent component)
    {
        
        super (label,
               false,
               null);

        this.component = component;
        
    }
            
    @Override
    public JComponent getComponent ()
    {
        
        return this.component;
        
    }
    
    @Override
    public String getValue ()
    {
        
        return null;
    
    }
    
    @Override
    public boolean hasError ()
    {
    
        return false;
                    
    }
        
}
