package inkon.editors.messages;

@FunctionalInterface
public interface EditorMessageFilter
{

    public boolean accept (EditorMessage m);

}
