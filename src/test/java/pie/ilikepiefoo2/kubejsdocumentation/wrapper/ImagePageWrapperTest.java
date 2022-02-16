package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import org.junit.Test;

import java.util.Collections;

public class ImagePageWrapperTest {

    @Test
    public void toJSON() {
        ImagePageWrapper imagePageWrapper = new ImagePageWrapper(Collections.emptyList());
        System.out.println(imagePageWrapper.toJSON());
    }
}