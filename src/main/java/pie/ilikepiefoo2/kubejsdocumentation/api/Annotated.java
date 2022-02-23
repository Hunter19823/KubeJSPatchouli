package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface Annotated {
    default SimpleAnnotation[] getAnnotations() {
        return new SimpleAnnotation[0];
    }
}
