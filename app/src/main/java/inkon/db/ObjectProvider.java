package inkon.db;

import java.util.*;

import inkon.*;
import inkon.data.*;

public interface ObjectProvider<E extends DataObject>
{
    
    public Set<E> getAll ()
                   throws GeneralException;
    
    public E getByKey (Long key);
    
    public void save (E      obj)
                      throws GeneralException;
                      
    public void saveAll (List<E> objs)
                         throws  GeneralException;
    
}