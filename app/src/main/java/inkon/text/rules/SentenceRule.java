package inkon.text.rules;

import java.util.*;

import inkon.text.*;

public interface SentenceRule extends Rule<Sentence>
{

    public List<Issue> getIssues (Sentence sentence);
    
}
