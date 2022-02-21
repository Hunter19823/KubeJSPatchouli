package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleClass extends Annotatable {
    SimpleClass getSuperClass();

    String getSimpleName();

    String getFullUniqueName();

    SimplePackage getPackage();

    SimpleConstructor[] getDeclaredConstructors();
    SimpleConstructor[] getInheritedConstructors();

    SimpleMethod[] getDeclaredMethods();
    SimpleMethod[] getInheritedMethods();

    SimpleField[] getDeclaredFields();
    SimpleField[] getInheritedFields();

    SimpleClass[] getDeclaredClasses();
    SimpleClass[] getInheritedClasses();

    SimpleVariableType[] getGenericTypes();

    boolean isPublic();

    boolean isPrimitive();

    boolean isEnum();

    boolean isAnonymous();

    boolean isArray();
}
