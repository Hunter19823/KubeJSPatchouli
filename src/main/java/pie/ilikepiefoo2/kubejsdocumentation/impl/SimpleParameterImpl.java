package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotatedType;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotation;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleClass;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleParameter;

import java.lang.reflect.Parameter;
import java.util.Arrays;

public class SimpleParameterImpl implements SimpleParameter {
    private final String name;
    private SimpleClass type;
    private final SimpleAnnotatedType annotatedType;
    private final boolean namePresent;
    private final boolean implicit;
    private final boolean varArgs;
    private final SimpleAnnotation[] annotations;


    private Class<?> returnType;
    public SimpleParameterImpl(Parameter parameter, int index) {
        this.returnType = parameter.getType();
        this.name = (parameter.isNamePresent() ? parameter.getName() : "arg" + index);
        this.namePresent = parameter.isNamePresent();
        this.implicit = parameter.isImplicit();
        this.varArgs = parameter.isVarArgs();
        this.annotations = SimpleAnnotationImpl.getAnnotations(parameter.getAnnotations());
        this.annotatedType = new SimpleAnnotatedTypeImpl(parameter.getAnnotatedType());
    }

    public static SimpleParameter[] getParameters(Parameter[] parameters) {
        SimpleParameter[] arr = new SimpleParameter[parameters.length];
        for ( int i = 0; i < arr.length; i++) {
            arr[i] = new SimpleParameterImpl( parameters[i], i);
        }
        return arr;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isImplicit() {
        return implicit;
    }

    @Override
    public SimpleClass getType() {
        if(type == null) {
            this.type = SimpleClassImpl.of(returnType);
            this.returnType = null;
        }
        return type;
    }

    @Override
    public SimpleAnnotatedType getAnnotatedType() {
        return annotatedType;
    }

    @Override
    public boolean isNamePresent() {
        return namePresent;
    }

    @Override
    public boolean acceptsVariableAmounts() {
        return varArgs;
    }

    @Override
    public SimpleAnnotation[] getAnnotations() {
        return annotations;
    }

    @Override
    public String toString() {
        return "SimpleParameterImpl{" +
                "name='" + name + '\'' +
                ", type=" + (returnType != null ? returnType.getCanonicalName() : type.getFullUniqueName()) +
                ", annotatedType=" + annotatedType +
                ", namePresent=" + namePresent +
                ", implicit=" + implicit +
                ", varArgs=" + varArgs +
                ", annotations=" + Arrays.toString(annotations) +
                '}';
    }
}
