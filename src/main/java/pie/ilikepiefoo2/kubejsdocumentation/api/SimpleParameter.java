package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleParameter extends Annotated {
    String getName();

    boolean isImplicit();

    SimpleClass getType();
    SimpleAnnotatedType getAnnotatedType();

    boolean isNamePresent();

    boolean acceptsVariableAmounts();
}
