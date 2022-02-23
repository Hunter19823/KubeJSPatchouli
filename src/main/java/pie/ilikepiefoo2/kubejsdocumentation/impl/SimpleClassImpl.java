package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleClass;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleConstructor;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleField;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleMethod;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimplePackage;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleVariableType;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SimpleClassImpl implements SimpleClass {
    private static final Map<Class<?>,SimpleClass> CACHE = new LinkedHashMap<>();

    private SimpleClass superClass;
    private final String simpleName;
    private final String fullName;
    private SimplePackage simplePackage;
    private SimpleConstructor[] constructors;
    private SimpleMethod[] methods;
    private SimpleField[] fields;
    private SimpleClass[] classes;
    private SimpleVariableType[] genericTypes;
    private boolean isPublic;
    private boolean isPrimitive;
    private boolean isEnum;
    private boolean isAnonymous;
    private boolean isArray;
    private Class<?> subject;

    private SimpleClassImpl( Class<?> type ) {
        this.subject = type;
        this.simpleName = type.getSimpleName();
        this.fullName = type.getCanonicalName();

        this.isPublic = Modifier.isPublic( type.getModifiers() );
        this.isPrimitive = type.isPrimitive();
        this.isEnum = type.isEnum();
        this.isAnonymous = type.isAnonymousClass();
        this.isArray = type.isArray();

        this.genericTypes = SimpleVariableTypeImpl.getVariableTypes( type.getTypeParameters() );
    }

    public static SimpleClass of( Class<?> type ) {
        if( CACHE.containsKey(type) )
            return CACHE.get(type);
        CACHE.put(type, new SimpleClassImpl( type ));
        return CACHE.get(type);
    }

    public static SimpleClass[] getClasses( Class<?>[] classes ) {
        SimpleClass[] result = new SimpleClass[classes.length];
        for( int i = 0; i < classes.length; i++ )
            result[i] = SimpleClassImpl.of( classes[i] );
        return result;
    }

    public void init(){
        getSuperClass();
        getPackage();
        getClasses();
        getConstructors();
        getMethods();
        getFields();
    }

    public static void clearCache() {
        CACHE.clear();
    }

    @Override
    public SimpleClass getSuperClass() {
        if( this.superClass == null )
            if( subject.getSuperclass() != null )
                superClass = SimpleClassImpl.of( subject.getSuperclass() );
        return superClass;
    }

    @Override
    public String getSimpleName() {
        return simpleName;
    }

    @Override
    public String getFullUniqueName() {
        return fullName;
    }

    @Override
    public SimplePackage getPackage() {
        if( this.simplePackage == null )
            this.simplePackage = SimplePackageImpl.of( subject.getPackage() );
        return simplePackage;
    }

    @Override
    public SimpleConstructor[] getConstructors() {
        if( this.constructors == null )
            this.constructors = SimpleConstructorImpl.getConstructors( subject.getConstructors() );
        return constructors;
    }

    @Override
    public SimpleMethod[] getMethods() {
        if( this.methods == null )
            this.methods = SimpleMethodImpl.getMethods( subject.getMethods() );
        return methods;
    }

    @Override
    public SimpleField[] getFields() {
        if( this.fields == null )
            this.fields = SimpleFieldImpl.getFields( subject.getFields() );
        return fields;
    }

    @Override
    public SimpleClass[] getClasses() {
        if( this.classes == null )
            this.classes = SimpleClassImpl.getClasses( subject.getClasses() );

        return classes;
    }

    @Override
    public SimpleVariableType[] getGenericTypes() {
        return genericTypes;
    }

    @Override
    public boolean isPublic() {
        return isPublic;
    }

    @Override
    public boolean isPrimitive() {
        return isPrimitive;
    }

    @Override
    public boolean isEnum() {
        return isEnum;
    }

    @Override
    public boolean isAnonymous() {
        return isAnonymous;
    }

    @Override
    public boolean isArray() {
        return isArray;
    }

    @Override
    public String toString() {
        return "SimpleClassImpl{" +
                "superClass=" + (superClass == null ? null : superClass.getFullUniqueName()) +
                ", simpleName='" + simpleName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", simplePackage=" + simplePackage +
                ", constructors=" + Arrays.toString(constructors) +
                ", methods=" + Arrays.toString(methods) +
                ", fields=" + Arrays.toString(fields) +
                ", classes=" + Arrays.toString(classes) +
                ", genericTypes=" + Arrays.toString(genericTypes) +
                ", isPublic=" + isPublic +
                ", isPrimitive=" + isPrimitive +
                ", isEnum=" + isEnum +
                ", isAnonymous=" + isAnonymous +
                ", isArray=" + isArray +
                '}';
    }
}
