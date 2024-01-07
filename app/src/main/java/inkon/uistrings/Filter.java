package inkon.uistrings;

@FunctionalInterface
public interface Filter<E extends Node>
{

    public boolean accept (E n);

}
