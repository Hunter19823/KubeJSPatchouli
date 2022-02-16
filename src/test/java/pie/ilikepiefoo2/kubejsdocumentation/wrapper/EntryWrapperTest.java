package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.List;

public class EntryWrapperTest {

    @Test
    public void toJSON() {
        EntryWrapper entryWrapper = new EntryWrapper("Test","Test Category", "Test Icon", List.of(new EmptyPageWrapper()));
        System.out.println(entryWrapper.toJSON());
    }
}