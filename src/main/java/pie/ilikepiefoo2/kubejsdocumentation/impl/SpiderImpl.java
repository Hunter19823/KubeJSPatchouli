package pie.ilikepiefoo2.kubejsdocumentation.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleClass;
import pie.ilikepiefoo2.kubejsdocumentation.api.Spider;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SpiderImpl implements Spider {
    private static final Logger LOG = LogManager.getLogger();
    public Set<Class<?>> CLASSES_WALKED = new HashSet<>();
    public Set<Class<?>> NEW_CLASSES_FOUND = new HashSet<>();
    public Set<Class<?>> SPIDER_QUEUE = new HashSet<>();

    @Override
    public Set<SimpleClass> crawl( Class<?> clazz, int depth ) {
        if ( depth == 0 )
            return Collections.EMPTY_SET;
        LOG.info("Crawling {}", clazz);
        SPIDER_QUEUE.add( clazz );
        while( depth-- > 0 && !SPIDER_QUEUE.isEmpty()) {
            LOG.info("Crawling {}", SPIDER_QUEUE);
            crawl( SPIDER_QUEUE );
            LOG.info("Finished with depth {}", depth);
        }
        LOG.info("Finished crawling {}", clazz);
        Set<SimpleClass> result = new HashSet<>(CLASSES_WALKED.size());
        LOG.info("Found {} classes", result.size());
        LOG.info("Walked Classes {}", CLASSES_WALKED);
        LOG.info("Queued Classes {}", SPIDER_QUEUE);
        LOG.info("Processing classes walked...");
        for (Class<?> clazz1 : CLASSES_WALKED) {
            SimpleClassImpl simpleClass = (SimpleClassImpl) SimpleClassImpl.of(clazz1);
            simpleClass.init();
            result.add( simpleClass );
        }
//        LOG.info("Processing remaining classes...");
//        for (Class<?> clazz1 : SPIDER_QUEUE) {
//            SimpleClassImpl simpleClass = (SimpleClassImpl) SimpleClassImpl.of(clazz1);
//            simpleClass.init();
//            result.add( simpleClass );
//        }
        LOG.info("Finished processing classes");
        return result;
    }

    private void crawl( Set<Class<?>> classes) {
        Iterator<Class<?>> iterator = classes.iterator();
        while ( iterator.hasNext() ) {
            Class<?> next = iterator.next();
            crawl(next);
            iterator.remove();
        }
        SPIDER_QUEUE.addAll( NEW_CLASSES_FOUND );
        NEW_CLASSES_FOUND.clear();
    }
    private void crawl( Class<?> subject ) {
        LOG.info("Crawling {}", subject);
        //LOG.info("Crawling Fields");
        for (Field field : subject.getFields() ) {
            queue( field.getType() );
        }
        //LOG.info("Crawling Methods");
        for(Method method : subject.getMethods() ) {
            for (Class<?> parameterType : method.getParameterTypes() ) {
                queue( parameterType );
            }
            queue( method.getReturnType() );
        }
        //LOG.info("Crawling Constructors");
        for(Constructor<?> constructor : subject.getConstructors() ) {
            for (Class<?> parameterType : constructor.getParameterTypes() ) {
                queue(parameterType);
            }
        }
        //LOG.info("Crawling Inner Classes");
        for(Class<?> innerClass : subject.getClasses() ) {
            queue(innerClass);
        }
        for(Class<?> interfaces : subject.getInterfaces()) {
            queue(interfaces);
        }
        //LOG.info("Crawling Superclass {}", subject);
        Class<?> superClass = subject.getSuperclass();
        while ( superClass != null) {
            queue( superClass );
            superClass = superClass.getSuperclass();
        }
        CLASSES_WALKED.add( subject );
        //LOG.info("Finished crawling {}", subject);
    }

    private boolean hasBeenSearched( Class<?> subject ) {
        return CLASSES_WALKED.contains( subject ) || NEW_CLASSES_FOUND.contains( subject ) || SPIDER_QUEUE.contains(subject);
    }

    private void queue( Class<?> subject ) {
        if( !hasBeenSearched(subject) )
            if( !subject.isArray()) {
                NEW_CLASSES_FOUND.add(subject);
            } else {
                queue(subject.getComponentType());
            }
    }
}
