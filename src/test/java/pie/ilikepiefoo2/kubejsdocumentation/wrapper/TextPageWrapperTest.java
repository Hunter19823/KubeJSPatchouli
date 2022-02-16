package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import org.junit.Test;

public class TextPageWrapperTest {

    @Test
    public void toJSON() {
        TextPageWrapper textPageWrapper = new TextPageWrapper("This is text");
        System.out.println(textPageWrapper.toJSON());
    }
}