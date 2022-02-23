package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleClass extends Annotated {
    SimpleClass getSuperClass();

    String getSimpleName();

    String getFullUniqueName();

    SimplePackage getPackage();

    SimpleConstructor[] getConstructors();

    SimpleMethod[] getMethods();

    SimpleField[] getFields();

    SimpleClass[] getClasses();

    SimpleVariableType[] getGenericTypes();

    boolean isPublic();

    boolean isPrimitive();

    boolean isEnum();

    boolean isAnonymous();

    boolean isArray();
}
