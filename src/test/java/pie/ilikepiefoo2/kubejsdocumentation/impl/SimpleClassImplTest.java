package pie.ilikepiefoo2.kubejsdocumentation.impl;


import org.junit.Test;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleClass;

public class SimpleClassImplTest {

    @Test
    public void of() {
        SimpleClass simpleClass =  SimpleClassImpl.of(SimpleClassImpl.class);
        System.out.println(simpleClass);
        ((SimpleClassImpl) simpleClass).init();
        System.out.println(simpleClass);
    }
}