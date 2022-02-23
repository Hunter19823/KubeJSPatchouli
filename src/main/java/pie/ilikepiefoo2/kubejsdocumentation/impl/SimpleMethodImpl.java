package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotation;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleClass;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleMethod;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleParameter;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleMethodImpl implements SimpleMethod {
    private static final Map<Method,SimpleMethod> CACHE = new LinkedHashMap<>();
    private final String name;
    private final SimpleClass declaringClass;
    private final SimpleClass returnType;
    private final SimpleParameter[] parameters;
    private final boolean isPublic;
    private final boolean isStatic;
    private final SimpleAnnotation[] annotations;

    private SimpleMethodImpl( Method method) {
        this.name = method.getName();
        this.declaringClass = SimpleClassImpl.of( method.getDeclaringClass() );
        this.returnType = SimpleClassImpl.of( method.getReturnType() );
        this.parameters = SimpleParameterImpl.getParameters( method.getParameters() );
        this.isPublic = Modifier.isPublic( method.getModifiers() );
        this.isStatic = Modifier.isStatic( method.getModifiers() );
        this.annotations = SimpleAnnotationImpl.getAnnotations( method.getAnnotations() );
    }

    public static SimpleMethod of( Method method ) {
        if( CACHE.containsKey( method ) ) {
            return CACHE.get( method );
        }
        CACHE.put( method, new SimpleMethodImpl( method ) );
        return CACHE.get( method );
    }

    public static SimpleMethod[] getMethods( Method[] declaredMethods ) {
        SimpleMethod[] methods = new SimpleMethod[declaredMethods.length];
        for( int i = 0; i < declaredMethods.length; i++ ) {
            methods[i] = of( declaredMethods[i] );
        }
        return methods;
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
        return declaringClass;
    }

    @Override
    public SimpleClass getReturnType() {
        return returnType;
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
        return "SimpleMethodImpl{" +
                "name='" + name + '\'' +
                ", declaringClass=" + declaringClass.getFullUniqueName() +
                ", returnType=" + returnType.getFullUniqueName() +
                ", parameters=" + Arrays.toString(parameters) +
                ", isPublic=" + isPublic +
                ", isStatic=" + isStatic +
                ", annotations=" + Arrays.toString(annotations) +
                '}';
    }
}
