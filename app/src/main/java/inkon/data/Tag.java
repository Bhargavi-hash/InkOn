package inkon.data;

import java.util.*;

import org.dom4j.*;

public class Tag extends NamedObject
{

    public static final String OBJECT_TYPE = "tag";

    public Tag ()
    {

        super (OBJECT_TYPE);

    }

    @Override
    public Set<NamedObject> getAllNamedChildObjects ()
    {

        return null;

    }

    @Override
    public void getChanges (NamedObject old,
                            Element     root)
    {

    }

}
