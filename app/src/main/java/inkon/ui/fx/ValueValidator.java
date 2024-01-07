package inkon.ui.fx;

import javafx.beans.property.*;

@FunctionalInterface
public interface ValueValidator<E>
{

    public StringProperty isValid (E value);

}
