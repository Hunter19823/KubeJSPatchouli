package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface SimpleParameter extends Annotatable{
    String getName();

    boolean isImplicit();

    SimpleClass getType();

    boolean isNamePresent();

    boolean acceptsVariableAmounts();
}
