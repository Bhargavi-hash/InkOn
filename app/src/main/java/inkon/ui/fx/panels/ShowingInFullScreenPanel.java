package inkon.ui.fx.panels;

import java.util.*;

import javafx.scene.image.*;
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

public class ShowingInFullScreenPanel extends PanelContent<AbstractViewer>
{

    public static final String PANEL_ID = "showinginfullscreen";
    private Panel origPanel = null;

    public ShowingInFullScreenPanel (AbstractProjectViewer viewer,
                                     Panel                 origPanel)
    {

        super (viewer);
        this.origPanel = origPanel;

        VBox v = new VBox ();

        HBox b = new HBox ();
        b.getStyleClass ().add (StyleClassNames.TITLE);

        HBox ib = new HBox ();
        ImageView iv = new ImageView ();
        iv.getStyleClass ().add (StyleClassNames.ICON);
        iv.managedProperty ().bind (iv.visibleProperty ());
        ib.getChildren ().add (iv);

        BasicHtmlTextFlow t = BasicHtmlTextFlow.builder ()
            .styleClassName (StyleClassNames.TEXT)
            .text (getUILanguageStringProperty (fullscreen,overlay,title))
            .build ();
            /*
        HBox.setHgrow (t,
                       Priority.ALWAYS);
*/
        b.getChildren ().addAll (ib, t);

        v.getChildren ().add (b);

        this.getChildren ().add (v);

        this.setOnMousePressed (ev ->
        {

            viewer.exitFullScreen ();

        });

    }

    public Panel getOriginalPanel ()
    {

        return this.origPanel;

    }

    @Override
    public Panel createPanel ()
    {

        Panel panel = Panel.builder ()
            .content (this)
            .title (fullscreen,overlay,title)
            .styleClassName (StyleClassNames.SHOWINGINFULLSCREEN)
            .panelId (PANEL_ID)
            .build ();

        return panel;

    }

}
