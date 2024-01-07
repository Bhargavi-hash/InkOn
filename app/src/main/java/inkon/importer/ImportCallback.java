package inkon.importer;

import java.net.*;

import inkon.data.*;


public interface ImportCallback
{

    public void projectCreated (Project p,
                                URI     u);

    public void exceptionOccurred (Exception e,
                                   URI       u);

}
