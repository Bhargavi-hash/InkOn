package inkon.importer;

import java.io.*;

import inkon.data.*;


public interface DocumentImporter
{

    public Project convert (InputStream in,
                            String      fileExt)
                     throws Exception;

}
