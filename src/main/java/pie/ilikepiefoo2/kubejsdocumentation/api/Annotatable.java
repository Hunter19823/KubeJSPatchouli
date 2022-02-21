package pie.ilikepiefoo2.kubejsdocumentation.api;

public interface Annotatable {
    default SimpleAnnotation[] getAnnotations() {
        return new SimpleAnnotation[0];
    }
}
