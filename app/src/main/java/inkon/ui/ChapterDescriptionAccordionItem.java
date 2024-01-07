package inkon.ui;

import java.awt.Component;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.dnd.*;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.tree.*;

import com.jgoodies.forms.builder.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import inkon.data.*;
import inkon.*;
import inkon.ui.actionHandlers.*;
import inkon.ui.components.ActionAdapter;
import inkon.ui.renderers.*;

public class ChapterDescriptionAccordionItem extends ChapterFieldAccordionItem
{

    public ChapterDescriptionAccordionItem (ProjectViewer pv,
                                            Chapter       c)
    {

        super (pv,
               c);

    }

    @Override
    public boolean isBulleted ()
    {

        return false;

    }

    @Override
    public StringWithMarkup getFieldValue (Chapter c)
    {

        return c.getDescription ();

    }

    @Override
    public String getFieldName ()
    {

        return this.chapter.getLegacyTypeField (LegacyUserConfigurableObject.DESCRIPTION_LEGACY_FIELD_ID).getFormName ();
        //"Description";

    }

    @Override
    public void setFieldValue (StringWithMarkup v,
                               Chapter c)
    {

        c.setDescription (v);

    }

    @Override
    public String getFieldIconType ()
    {

        return Constants.INFO_ICON_NAME;

    }

}
