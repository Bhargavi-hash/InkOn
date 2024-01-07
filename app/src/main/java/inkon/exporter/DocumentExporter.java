package inkon.exporter;

import java.io.*;
import java.nio.file.*;

import inkon.*;

import inkon.data.*;

import inkon.ui.*;

import inkon.ui.fx.components.*;

public interface DocumentExporter
{

    public void exportProject (Path    dir,
                               Project itemsToExport)
                        throws GeneralException;

    public String getStartStage ();

    public WizardStep getStage (String stage);

    inkon.ui.fx.components.Wizard.Step getStage2 (String stage);

    public String getNextStage (String currStage);

    public String getPreviousStage (String currStage);

    public void setProject (Project p);

}
