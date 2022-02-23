package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotation;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleClass;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleConstructor;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleParameter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleConstructorImpl implements SimpleConstructor {
    private static final Map<Constructor<?>,SimpleConstructor> CACHE = new LinkedHashMap<>();

    private final String name;
    private SimpleClass declaringClass;
    private final SimpleParameter[] parameters;
    private final boolean isPublic;
    private final boolean isStatic;
    private final SimpleAnnotation[] annotations;

    private Class<?> declaringClassClass;
    private SimpleConstructorImpl( Constructor<?> constructor) {
        this.declaringClassClass = constructor.getDeclaringClass();

        this.name = constructor.getName();
        this.parameters = SimpleParameterImpl.getParameters( constructor.getParameters());
        this.isPublic = Modifier.isPublic( constructor.getModifiers());
        this.isStatic = Modifier.isStatic( constructor.getModifiers());
        this.annotations = SimpleAnnotationImpl.getAnnotations( constructor.getAnnotations());
    }

    public static SimpleConstructor of( Constructor<?> constructor) {
        if( constructor == null) {
            return null;
        }
        if( CACHE.containsKey( constructor ) )
            return CACHE.get( constructor );
        CACHE.put( constructor, new SimpleConstructorImpl( constructor ) );
        return CACHE.get( constructor );
    }

    public static SimpleConstructor[] getConstructors( Constructor<?>[] constructors) {
        SimpleConstructor[] output = new SimpleConstructor[constructors.length];
        for( int i = 0; i < output.length; i++) {
            output[i] = of( constructors[i] );
        }
        return output;
    }

    public static void clearCache() {
        CACHE.clear();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public SimpleClass getDeclaringClass() {
        if( declaringClass == null ) {
            declaringClass = SimpleClassImpl.of( declaringClassClass );
            declaringClassClass = null;
        }
        return declaringClass;
    }

    @Override
    public SimpleClass getReturnType() {
        return getDeclaringClass();
    }

    @Override
    public SimpleParameter[] getParameters() {
        return parameters;
    }

    @Override
    public int getParameterCount() {
        return parameters.length;
    }

    @Override
    public boolean isPublic() {
        return isPublic;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public SimpleAnnotation[] getAnnotations() {
        return annotations;
    }

    @Override
    public String toString() {
        return "SimpleConstructorImpl{" +
                "name='" + name + '\'' +
                ", declaringClass=" + (declaringClassClass != null ? declaringClassClass.getCanonicalName() : declaringClass.getFullUniqueName()) +
                ", returnType=" +  (declaringClassClass != null ? declaringClassClass.getCanonicalName() : declaringClass.getFullUniqueName()) +
                ", parameters=" + Arrays.toString(parameters) +
                ", isPublic=" + isPublic +
                ", isStatic=" + isStatic +
                ", annotations=" + Arrays.toString(annotations) +
                '}';
    }
}
