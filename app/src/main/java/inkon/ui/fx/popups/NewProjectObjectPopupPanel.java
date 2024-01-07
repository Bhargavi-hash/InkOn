package inkon.ui.fx.popups;

import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;
import java.util.function.*;

import javafx.event.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.scene.*;
import javafx.scene.layout.*;

import inkon.*;
import inkon.data.*;
import inkon.editors.*;
import inkon.ui.fx.*;
import inkon.ui.fx.components.*;
import inkon.ui.fx.viewers.*;

import static inkon.uistrings.UILanguageStringsManager.getUILanguageStringProperty;
import inkon.uistrings.UILanguageStringsManager;
import static inkon.LanguageStrings.*;

public class NewProjectObjectPopupPanel<E extends AbstractProjectViewer> extends VBox
{

    private LinkedToPanel linkedToPanel = null;

    private NewProjectObjectPopupPanel (Builder<E> b)
    {

        Form.Builder fb = Form.builder ()
            .confirmButton (buttons,save)
            .cancelButton (buttons,cancel);

        b.controls.keySet ().stream ()
            .forEach (l ->
            {

                fb.item (l,
                         b.controls.get (l));

            });

        if (b.showLinkedTo)
        {

            if (b.binder == null)
            {

                throw new IllegalStateException ("If showLinkedTo is true then the property binder must be provided.");

            }

            HyperlinkLinkedToPanel lp = new HyperlinkLinkedToPanel (b.viewer.getProject (),
                                                                    b.binder,
                                                                    b.viewer);

            this.linkedToPanel = lp.getLinkedToPanel ();

            fb.item (lp);

        }

        Form f = fb.build ();

        f.setOnConfirm (ev ->
        {

            if (b.onConfirm != null)
            {

                b.onConfirm.accept (ev, this.getSelectedLinkObjects ());

            }

        });

        f.setOnCancel (b.onCancel);

        this.getChildren ().add (f);

    }

    public Set<NamedObject> getSelectedLinkObjects ()
    {

        if (this.linkedToPanel == null)
        {

            return new LinkedHashSet<> ();

        }

        return this.linkedToPanel.getSelected ();

    }

    public static <E extends AbstractProjectViewer> NewProjectObjectPopupPanel.Builder<E> builder ()
    {

        return new Builder<> ();

    }

    public static class Builder<E extends AbstractProjectViewer> implements IBuilder<Builder<E>, NewProjectObjectPopupPanel<E>>
    {

        private BiConsumer<Form.FormEvent, Set<NamedObject>> onConfirm = null;
        private EventHandler<Form.FormEvent> onCancel = null;
        private boolean showLinkedTo = true;
        private E viewer = null;
        private Map<StringProperty, Node> controls = new LinkedHashMap<> ();
        private IPropertyBinder binder = null;

        private Builder ()
        {

        }

        public Builder<E> withViewer (E viewer)
        {

            this.viewer = viewer;
            return this;

        }

        public Builder<E> withBinder (IPropertyBinder b)
        {

            this.binder = b;
            return this;

        }

        public Builder<E> showLinkedTo (boolean v)
        {

            this.showLinkedTo = v;
            return this;

        }

        public Builder<E> onConfirm (BiConsumer<Form.FormEvent, Set<NamedObject>> on)
        {

            this.onConfirm = on;
            return this;

        }

        public Builder<E> onCancel (EventHandler<Form.FormEvent> on)
        {

            this.onCancel = on;
            return this;

        }

        public Builder<E> item (StringProperty label,
                                Node           control)
        {

            this.controls.put (label,
                               control);
            return this;

        }

        public Builder<E> item (List<String> labelIds,
                                Node         control)
        {

            this.controls.put (getUILanguageStringProperty (labelIds),
                               control);
            return this;

        }

        @Override
        public NewProjectObjectPopupPanel<E> build ()
        {

            return new NewProjectObjectPopupPanel<> (this);

        }

        @Override
        public Builder<E> _this ()
        {

            return this;

        }

    }

}
