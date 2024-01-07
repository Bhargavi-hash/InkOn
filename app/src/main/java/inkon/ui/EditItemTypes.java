package inkon.ui;

import java.awt.*;
import java.awt.event.*;

import java.io.File;

import java.net.*;

import java.text.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import javax.swing.table.*;
import javax.swing.tree.*;

import com.jgoodies.forms.builder.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

import inkon.*;

import inkon.data.*;
import inkon.data.comparators.*;

import inkon.exporter.*;

import inkon.ui.components.*;
import inkon.ui.renderers.*;

public class EditItemTypes extends TypesEditor<AbstractViewer, UserPropertyHandler>
{

    public EditItemTypes (AbstractViewer pv)
    {

        super (pv);

    }

    @Override
    public UserPropertyHandler getTypesHandler ()
    {

        return Environment.getUserPropertyHandler (Constants.OBJECT_TYPES_PROPERTY_NAME);

    }

    public String getNewTypeHelp ()
    {

        return "Note: removing a type will only remove it from the list of types to select when adding/editing an {object}.  You can also change the type name by editing the values, double click on a type to begin.";

    }

    public String getTypesName ()
    {

        return "{Object} Types";

    }

}
