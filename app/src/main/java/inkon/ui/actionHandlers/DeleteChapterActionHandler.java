package inkon.ui.actionHandlers;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import inkon.*;

import inkon.data.*;

import inkon.ui.*;
import inkon.ui.components.ActionAdapter;


public class DeleteChapterActionHandler extends YesDeleteConfirmTextInputActionHandler<AbstractProjectViewer>
{

    private Chapter               chapter = null;

    public DeleteChapterActionHandler(Chapter               c,
                                      AbstractProjectViewer pv)
    {

        super (pv,
               c);
        this.chapter = c;

    }

    @Override
    public String getDeleteType ()
    {
        
        return Environment.getUIString (LanguageStrings.project,
                                        LanguageStrings.actions,
                                        LanguageStrings.deletechapter,
                                        LanguageStrings.deletetype);
        //"{Chapter}";
        
    }
        
    @Override
    public String getWarning ()
    {
        
        return Environment.getUIString (LanguageStrings.project,
                                        LanguageStrings.actions,
                                        LanguageStrings.deletechapter,
                                        LanguageStrings.warning);
        //"Warning!  Once deleted a {chapter} cannot be restored.";
        
    }
            
    @Override
    public boolean onConfirm (String v)
                              throws Exception
    {

        this.viewer.deleteChapter (this.chapter);

        return true;
        
    }
    
}
