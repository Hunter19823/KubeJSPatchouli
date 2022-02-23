package pie.ilikepiefoo2.kubejsdocumentation.impl;


import net.minecraft.client.Minecraft;
import org.junit.Test;
import pie.ilikepiefoo2.kubejsdocumentation.api.SimpleClass;

import java.util.Set;

public class SpiderImplTest {

    @Test
    public void crawl() {
        SpiderImpl spider = new SpiderImpl();
        Set<SimpleClass> classSet = spider.crawl(Minecraft.class,100);
        System.out.println(classSet.size());
    }
}