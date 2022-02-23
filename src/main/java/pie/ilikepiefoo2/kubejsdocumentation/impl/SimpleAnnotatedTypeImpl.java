package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotatedType;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotation;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleType;

import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

public class SimpleAnnotatedTypeImpl implements SimpleAnnotatedType {
    private final SimpleType type;
    private final SimpleAnnotation[] annotations;

    public SimpleAnnotatedTypeImpl( AnnotatedType type ) {
        this.type = new SimpleTypeImpl( type.getType() );
        this.annotations = SimpleAnnotationImpl.getAnnotations( type.getAnnotations() );
    }

    public static SimpleAnnotatedType[] getAnnotatedTypes( AnnotatedType[] types ) {
        SimpleAnnotatedType[] result = new SimpleAnnotatedType[types.length];
        for ( int i = 0; i < types.length; i++ ) {
            result[i] = new SimpleAnnotatedTypeImpl( types[i] );
        }
        return result;
    }

    @Override
    public SimpleType getType() {
        return this.type;
    }

    @Override
    public SimpleAnnotation[] getAnnotations() {
        return this.annotations;
    }

    @Override
    public String toString() {
        return "SimpleAnnotatedTypeImpl{" +
                "type=" + type +
                ", annotations=" + Arrays.toString(annotations) +
                '}';
    }
}
