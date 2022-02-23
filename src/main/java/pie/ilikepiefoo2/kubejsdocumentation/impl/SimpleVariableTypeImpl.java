package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotatedType;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleType;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleVariableType;

import java.lang.reflect.TypeVariable;

public class SimpleVariableTypeImpl implements SimpleVariableType {

    private final String name;
    private final SimpleType[] bounds;
    private final SimpleAnnotatedType[] annotations;

    public SimpleVariableTypeImpl( TypeVariable<?> typeVariable ) {
        this.name = typeVariable.getName();
        this.bounds = SimpleTypeImpl.getTypes( typeVariable.getBounds() );
        this.annotations = SimpleAnnotatedTypeImpl.getAnnotatedTypes(typeVariable.getAnnotatedBounds());
    }

    public static SimpleVariableType[] getVariableTypes( TypeVariable<?>[] typeVariables ) {
        SimpleVariableType[] variableTypes = new SimpleVariableType[typeVariables.length];
        for ( int i = 0; i < typeVariables.length; i++ ) {
            variableTypes[i] = new SimpleVariableTypeImpl( typeVariables[i] );
        }
        return variableTypes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public SimpleType[] getBounds() {
        return bounds;
    }

    @Override
    public SimpleAnnotatedType[] getAnnotatedBounds() {
        return annotations;
    }
}
