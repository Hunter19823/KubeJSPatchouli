package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleVariableType {
    String getName();

    SimpleType[] getBounds();

    SimpleAnnotatedType[] getAnnotatedBounds();
}
