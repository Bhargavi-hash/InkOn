package inkon;

import inkon.ui.events.*;

import inkon.ui.fx.*;

public interface DictionaryProvider2
{

    public void addDictionaryChangedListener (DictionaryChangedListener l);

    public void removeDictionaryChangedListener (DictionaryChangedListener l);

    public SpellChecker getSpellChecker ();

    public void removeWord (String word);

    public void addWord (String word);

}
