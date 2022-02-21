package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleField extends Annotatable {
    String getName();

    SimpleClass getDeclaringClass();

    SimpleClass getType();

    String getGenericType();

    boolean isMutable();

    boolean isPublic();

    boolean isStatic();

    boolean isFinal();
}
