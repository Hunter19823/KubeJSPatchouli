package pie.ilikepiefoo2.kubejsdocumentation.wrapper;


import org.junit.Test;

public class CategoryWrapperTest {

    @Test
    public void toJSON() {
        CategoryWrapper categoryWrapper = new CategoryWrapper("Test", "Test", "Test Icon");
        System.out.println(categoryWrapper.toJSON());
    }
}