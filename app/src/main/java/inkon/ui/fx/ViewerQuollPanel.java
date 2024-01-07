package inkon.ui.fx;

import java.io.*;

import java.text.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gentlyweb.properties.*;

import inkon.ui.Stateful;
import inkon.ui.AbstractViewer;
import inkon.GeneralException;
import inkon.data.*;

import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public interface ViewerQuollPanel
{

    public abstract void fillToolBar (ToolBar toolBar,
                                      boolean  fullScreen);

}
