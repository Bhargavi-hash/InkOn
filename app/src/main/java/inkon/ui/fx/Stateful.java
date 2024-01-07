package inkon.ui.fx;

import java.util.*;

import inkon.*;

public interface Stateful
{

    public void init (State state)
               throws GeneralException;

    public State getState ();

}
