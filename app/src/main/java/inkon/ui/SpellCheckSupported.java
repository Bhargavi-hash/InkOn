package inkon.ui;

import inkon.*;


public interface SpellCheckSupported
{

    public void setSpellCheckingEnabled (boolean v);

    public void setDictionaryProvider (DictionaryProvider2 dp);

    public void checkSpelling ();

}
