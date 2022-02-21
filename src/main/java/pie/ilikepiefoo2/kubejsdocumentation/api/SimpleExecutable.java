package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleExecutable extends Annotatable{
    String getName();

    SimpleClass getDeclaringClass();

    SimpleClass getReturnType();

    SimpleParameter[] getParameters();

    int getParameterCount();

    boolean isPublic();

    boolean isStatic();
}
