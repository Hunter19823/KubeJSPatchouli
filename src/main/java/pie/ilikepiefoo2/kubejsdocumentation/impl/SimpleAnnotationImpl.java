package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotation;

import java.lang.annotation.Annotation;

public class SimpleAnnotationImpl implements SimpleAnnotation {
    private final String annotation;
    public SimpleAnnotationImpl( Annotation annotation ) {
        this.annotation = annotation.annotationType().getName();
    }

    @Override
    public String getAnnotation() {
        return annotation;
    }

    @Override
    public String toString(){
        return this.annotation;
    }

    public static SimpleAnnotation[] getAnnotations( Annotation[] annotations ) {
        SimpleAnnotation[] result = new SimpleAnnotation[annotations.length];
        for( int i = 0; i < annotations.length; i++ ) {
            result[i] = new SimpleAnnotationImpl(annotations[i]);
        }
        return result;
    }

}
