package inkon.achievements.rules;

import java.util.*;

import org.dom4j.*;

import javafx.beans.property.*;

import inkon.ui.fx.*;
import inkon.ui.fx.viewers.*;

public interface AchievementRule
{

    public StringProperty nameProperty ();

    public StringProperty descriptionProperty ();

    // TODO Remove? public String getName ();

    public String getIcon ();

    // TODO Remove? public String getDescription ();

    public String getId ();

    public Set<String> getEventIds ();

    public boolean shouldPersistState ();

    public boolean isEventTrigger ();

    public boolean isHidden ();

    public String getCategory ();

    public boolean achieved (AbstractProjectViewer viewer,
                             ProjectEvent          ev)
                             throws                Exception;

    public boolean achieved (ProjectEvent ev)
                             throws       Exception;

    public boolean achieved (AbstractProjectViewer viewer)
                             throws                Exception;

    public void init (Element root);

    public void fillState (Element root);

}
