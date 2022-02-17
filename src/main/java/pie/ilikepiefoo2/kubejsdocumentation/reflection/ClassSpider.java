package pie.ilikepiefoo2.kubejsdocumentation.reflection;

import java.util.HashSet;
import java.util.Set;

public class ClassSpider {
    public static Set<Class> CLASSES_WALKED = new HashSet<>();
    public static Set<Class> NEW_CLASSES_FOUND = new HashSet<>();
    public static Set<ClassSpider> SPIDER_QUEUE = new HashSet<>();
    private final Class subject;
    private final int depth;
    public ClassSpider(Class subject, int depth) {
        this.depth = depth;
        this.subject = subject;
    }
}
