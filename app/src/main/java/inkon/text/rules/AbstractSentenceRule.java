package inkon.text.rules;

import inkon.*;
import inkon.text.*;

public abstract class AbstractSentenceRule extends AbstractRule<Sentence> implements SentenceRule
{

    public AbstractSentenceRule ()
    {

    }

    public String getEditSummary ()
    {

        return this.summary;

    }

    public String getEditDescription ()
    {

        return this.desc;

    }

    @Override
    public String getEditFormTitle (boolean add)
    {

        return (add ? Environment.getUIString (LanguageStrings.problemfinder,
                                               LanguageStrings.config,
                                               LanguageStrings.rules,
                                               LanguageStrings.sentence,
                                               LanguageStrings.addtitle) : null);

    }

}
