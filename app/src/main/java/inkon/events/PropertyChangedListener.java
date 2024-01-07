package inkon.events;

import java.util.EventListener;


public interface PropertyChangedListener extends EventListener
{

    public void propertyChanged (PropertyChangedEvent ev);

}
