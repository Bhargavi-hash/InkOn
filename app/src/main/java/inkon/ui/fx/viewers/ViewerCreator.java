package inkon.ui.fx.viewers;

import inkon.*;
import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;
import inkon.ui.fx.components.*;

/**
 * A base class for content that is suitable for display within a Viewer.
 */
public interface ViewerCreator
{

    Viewer createViewer ()
                  throws GeneralException;

}
