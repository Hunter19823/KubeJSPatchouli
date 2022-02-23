package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotation;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleClass;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleField;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleFieldImpl implements SimpleField {
    private static final Map<Field, SimpleField> CACHE = new LinkedHashMap<>();

    private final String name;
    private SimpleClass declaringClass;
    private SimpleClass type;
    private final String genericType;
    private final boolean isPublic;
    private final boolean isStatic;
    private final boolean isFinal;
    private final SimpleAnnotation[] annotations;

    private Class<?> fieldType;
    private Class<?> declaringClassType;
    private SimpleFieldImpl( Field field ) {
        this.fieldType = field.getType();
        this.declaringClassType = field.getDeclaringClass();

        this.name = field.getName();
        this.genericType = field.getGenericType().toString();
        this.isFinal = Modifier.isFinal( field.getModifiers() );
        this.isPublic = Modifier.isPublic( field.getModifiers() );
        this.isStatic = Modifier.isStatic( field.getModifiers() );
        this.annotations = SimpleAnnotationImpl.getAnnotations( field.getAnnotations() );
    }

    public static SimpleField of( Field field ) {
        if( CACHE.containsKey( field ) )
            return CACHE.get(field);
        CACHE.put( field, new SimpleFieldImpl( field ) );
        return CACHE.get( field );
    }

    public static SimpleField[] getFields( Field[] declaredFields ) {
        SimpleField[] fields = new SimpleField[declaredFields.length];
        for( int i = 0; i < declaredFields.length; i++ )
            fields[i] = SimpleFieldImpl.of( declaredFields[i] );
        return fields;
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
            declaringClass = SimpleClassImpl.of(declaringClassType);
            declaringClassType = null;
        }
        return declaringClass;
    }

    @Override
    public SimpleClass getType() {
        if( type == null ) {
            type = SimpleClassImpl.of(fieldType);
            fieldType = null;
        }
        return type;
    }

    @Override
    public String getGenericType() {
        return genericType;
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
    public boolean isFinal() {
        return isFinal;
    }

    @Override
    public SimpleAnnotation[] getAnnotations() {
        return annotations;
    }

    @Override
    public String toString() {
        return "SimpleFieldImpl{" +
                "name='" + name + '\'' +
                ", declaringClass=" + (declaringClassType == null ? declaringClass.getFullUniqueName() : declaringClassType.getCanonicalName() ) +
                ", type=" + (fieldType == null ? type.getFullUniqueName() : fieldType.getCanonicalName() ) +
                ", genericType='" + genericType + '\'' +
                ", isPublic=" + isPublic +
                ", isStatic=" + isStatic +
                ", isFinal=" + isFinal +
                ", annotations=" + Arrays.toString(annotations) +
                '}';
    }
}
