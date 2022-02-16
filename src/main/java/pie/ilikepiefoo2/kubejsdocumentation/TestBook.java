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
        FILE_LIST.add(book);
        CategoryWrapper category = new CategoryWrapper("TestCategory", "TestCategory Description", "minecraft:stone#64");
        FILE_LIST.add(category);
        TextPageWrapper textPage = new TextPageWrapper("This is the test page.");
        LinkPageWrapper linkPage = new LinkPageWrapper("This is the test page.", "https://minecraft.gamepedia.com/","This is a link to the Minecraft Wiki");
        ImagePageWrapper imagePage = new ImagePageWrapper(List.of("https://static.wikia.nocookie.net/minecraft_gamepedia/images/9/90/Minecraft_Wiki_header.svg/revision/latest/scale-to-width-down/300?cb=20211226202542"));
        imagePage.setText("This image page also has text!");
        RelationsPageWrapper relationsPage = new RelationsPageWrapper();
        relationsPage.setText("This is a relations page. It links to other pages.");
        List<String> entries = new ArrayList<>();
        relationsPage.setEntries(entries);
        EntryWrapper entry = new EntryWrapper("TestEntry", "TestEntry Description", "minecraft:stone#64",List.of(textPage,linkPage,imagePage,relationsPage));
        entries.add(entry.getResourceLocation().toString());
        FILE_LIST.add(entry);
        return FILE_LIST;
    }
}
