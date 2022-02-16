package pie.ilikepiefoo2.kubejsdocumentation.wrapper;


import org.junit.Test;

public class EmptyPageWrapperTest {
    @Test
    public void toJSON() {
        EmptyPageWrapper emptyPageWrapper = new EmptyPageWrapper();
        System.out.println(emptyPageWrapper.toJSON());
    }
}