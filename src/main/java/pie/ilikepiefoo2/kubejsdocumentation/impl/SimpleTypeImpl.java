package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleType;

import java.lang.reflect.Type;

public class SimpleTypeImpl implements SimpleType {
    private final String name;

    public SimpleTypeImpl( Type type ) {
        this.name = type.getTypeName();
    }

    public static SimpleType[] getTypes( Type[] types ) {
        SimpleType[] simpleTypes = new SimpleType[types.length];
        for ( int i = 0; i < types.length; i++ ) {
            simpleTypes[i] = new SimpleTypeImpl( types[i] );
        }
        return simpleTypes;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
