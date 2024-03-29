package inkon.data.comparators;

import java.util.*;

import inkon.data.*;


public class OutlineItemSorter implements Comparator<OutlineItem>
{

    public int compare (OutlineItem o1,
                        OutlineItem o2)
    {

        return o1.getPosition () - o2.getPosition ();

    }

    public boolean equals (Object o)
    {

        return this == o;

    }

}
