package inkon.text.rules;

import java.util.*;

import inkon.text.*;

public interface ParagraphRule extends Rule<Paragraph>
{

    public List<Issue> getIssues (Paragraph paragraph);

}
