package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleExecutable extends Annotated {
    String getName();

    SimpleClass getDeclaringClass();

    SimpleClass getReturnType();

    SimpleParameter[] getParameters();

    int getParameterCount();

    boolean isPublic();

    boolean isStatic();
}
