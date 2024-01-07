package inkon.ui.fx.panels;

import java.util.*;

import javafx.beans.property.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import inkon.ui.fx.viewers.*;
import inkon.ui.fx.components.*;
import inkon.ui.fx.panels.*;
import inkon.ui.fx.*;
import inkon.*;

import static inkon.LanguageStrings.*;
import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;

public class ImportFilePanel extends PanelContent<AbstractViewer>
{

    public static final String PANEL_ID = "importfile";

    public ImportFilePanel (AbstractViewer viewer)
    {

        super (viewer);

        Label header = new Label ();
        header.getStyleClass ().add (StyleClassNames.TITLE);
        header.textProperty ().bind (getUILanguageStringProperty (general,importfile));

        this.getChildren ().add (header);

    }

    @Override
    public Panel createPanel ()
    {

        Panel panel = Panel.builder ()
            .content (this)
            .title (general,importfile)
            .styleClassName (StyleClassNames.IMPORTFILE)
            .panelId (PANEL_ID)
            .build ();

        return panel;

    }

}
