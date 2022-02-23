package pie.ilikepiefoo2.kubejsdocumentation.impl;

import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleAnnotation;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimplePackage;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimplePackageImpl implements SimplePackage {
    private static final Map<Package, SimplePackage> CACHE = new LinkedHashMap<>();

    private final String name;
    private final String implName;
    private final String specName;
    private final String version;
    private final String author;

    private final SimpleAnnotation[] annotations;

    private SimplePackageImpl(Package pack) {
        this.name = pack.getName();
        this.implName = pack.getImplementationTitle();
        this.specName = pack.getSpecificationTitle();
        this.version = pack.getImplementationVersion();
        this.author = pack.getImplementationVendor();
        this.annotations = SimpleAnnotationImpl.getAnnotations(pack.getAnnotations());
    }

    public static SimplePackage of(Package pack) {
        if(CACHE.containsKey(pack))
            return CACHE.get(pack);
        if(pack == null)
            return null;
        CACHE.put(pack, new SimplePackageImpl(pack));
        return CACHE.get(pack);
    }

    public static void clearCache() {
        CACHE.clear();
    }

    @Override
    public String getPackageName() {
        return name;
    }

    @Override
    public String getImplTitle() {
        return implName;
    }

    @Override
    public String getSpecTitle() {
        return specName;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getVendor() {
        return author;
    }

    @Override
    public SimpleAnnotation[] getAnnotations() {
        return annotations;
    }

    @Override
    public String toString() {
        return "SimplePackageImpl{" +
                "name='" + name + '\'' +
                ", implName='" + implName + '\'' +
                ", specName='" + specName + '\'' +
                ", version='" + version + '\'' +
                ", author='" + author + '\'' +
                ", annotations=" + Arrays.toString(annotations) +
                '}';
    }
}
