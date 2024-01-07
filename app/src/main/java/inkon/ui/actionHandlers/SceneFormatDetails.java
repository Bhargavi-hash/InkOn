package inkon.ui.actionHandlers;

import java.util.Set;

import java.awt.event.ActionListener;

import javax.swing.*;

import inkon.*;

import inkon.data.*;

import inkon.ui.*;
import inkon.ui.panels.*;

public class SceneFormatDetails implements ChapterItemFormatDetails<Scene, ProjectViewer>
{

    public String getIcon (Scene item)
    {

        return item.getObjectType ();

    }

    public String getTitle (Scene item)
    {

        return Environment.getObjectTypeName (item.getObjectType ()).getValue ();

    }

    public String getItemDescription (Scene item)
    {

        if (item == null)
        {

            return null;

        }

        if (item.getDescription () == null)
        {

            return null;

        }

        return item.getDescription ().getMarkedUpText ();

    }

    @Override
    public Set<JComponent> getTools (Scene                            item,
                                     ChapterItemViewer<ProjectViewer> qep)
    {

        return null;

    }

    public ActionListener getEditItemActionHandler (Scene                            item,
                                                    ChapterItemViewer<ProjectViewer> ep)
    {

        return new ChapterItemActionHandler (item,
                                             ep,
                                             ChapterItemActionHandler.EDIT,
                                             -1);

    }

    public ActionListener getDeleteItemActionHandler (Scene                            item,
                                                      ChapterItemViewer<ProjectViewer> ep,
                                                      boolean                          showAtItem)
    {

        return new DeleteChapterItemActionHandler (item,
                                                   ep.getViewer (),
                                                   showAtItem);

    }

}
