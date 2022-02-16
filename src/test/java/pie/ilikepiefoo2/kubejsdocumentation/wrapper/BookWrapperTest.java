package pie.ilikepiefoo2.kubejsdocumentation.wrapper;


import org.junit.Test;

public class BookWrapperTest {

    @Test
    public void toJSON() {
        BookWrapper bookWrapper = new BookWrapper("Test","This is the landing Text.");
        System.out.println(bookWrapper.toJSON());
    }
}