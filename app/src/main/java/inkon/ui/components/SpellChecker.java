package inkon.ui.components;

import java.util.*;

import inkon.text.*;

public interface SpellChecker
{

    public boolean isCorrect (Word word);

    public boolean isIgnored (Word word);

    public List<String> getSuggestions (Word word);

}
