package pie.ilikepiefoo2.kubejsdocumentation.api;

import java.util.Set;

public interface Spider {
    Set<SimpleClass> crawl(Class<?> clazz, int depth);
}
