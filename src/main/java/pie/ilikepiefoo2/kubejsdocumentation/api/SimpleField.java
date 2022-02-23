package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleField extends Annotated {
    String getName();

    SimpleClass getDeclaringClass();

    SimpleClass getType();

    String getGenericType();

    boolean isPublic();

    boolean isStatic();

    boolean isFinal();
}
