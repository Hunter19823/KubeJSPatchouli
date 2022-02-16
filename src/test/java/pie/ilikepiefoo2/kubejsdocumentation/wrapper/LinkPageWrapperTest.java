package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import org.junit.Test;

public class LinkPageWrapperTest {

    @Test
    public void toJSON() {
        LinkPageWrapper linkPageWrapper = new LinkPageWrapper("This is the text on the page", "This is the Title", "This is the URL.");
        System.out.println(linkPageWrapper.toJSON());
    }
}