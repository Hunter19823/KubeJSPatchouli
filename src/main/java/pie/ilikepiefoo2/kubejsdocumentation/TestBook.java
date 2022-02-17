package pie.ilikepiefoo2.kubejsdocumentation;

import pie.ilikepiefoo2.kubejsdocumentation.wrapper.BookWrapper;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.CategoryWrapper;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.EntryWrapper;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.ImagePageWrapper;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.LinkPageWrapper;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.PatchouliFile;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.RelationsPageWrapper;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.TextPageWrapper;

import java.util.ArrayList;
import java.util.List;

public class TestBook {
    private static final List<PatchouliFile> FILE_LIST = new ArrayList<>();

    public static final List<PatchouliFile> getTestBook(){
        if(FILE_LIST.size() != 0)
            return FILE_LIST;
        BookWrapper book = new BookWrapper("TestBook", "TestBook");
        book.dont_generatebook = false;
        FILE_LIST.add(book);
        CategoryWrapper category = new CategoryWrapper("TestCategory", "TestCategory Description", "minecraft:stone#64");
        FILE_LIST.add(category);
        TextPageWrapper textPage = new TextPageWrapper("This is the test page.");
        LinkPageWrapper linkPage = new LinkPageWrapper("This is the test page.", "https://minecraft.gamepedia.com/","This is a link to the Minecraft Wiki");
        ImagePageWrapper imagePage = new ImagePageWrapper(List.of("patchouli:textures/gui/book_green.png"));
        imagePage.setText("This image page also has text!");
        RelationsPageWrapper relationsPage = new RelationsPageWrapper();
        relationsPage.setText("This is a relations page. It links to other pages.");
        List<String> entries = new ArrayList<>();
        relationsPage.setEntries(entries);
        EntryWrapper entry = new EntryWrapper("TestEntry", "patchouli:testcategory", "minecraft:stone#64",List.of(textPage,linkPage,imagePage,relationsPage));
        relationsPage.getEntries().add("patchouli:testentry");
        FILE_LIST.add(entry);
        return FILE_LIST;
    }
}
