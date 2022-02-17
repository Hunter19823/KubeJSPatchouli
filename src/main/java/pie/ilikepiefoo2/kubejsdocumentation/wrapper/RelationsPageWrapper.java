package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import java.util.ArrayList;
import java.util.List;

public class RelationsPageWrapper extends PageWrapper{
    public List<String> entries;
    public String title;
    public String text;

    public RelationsPageWrapper(){
        super("patchouli:relations");
    }

    public List<String> getEntries() {
        return entries;
    }

    public void setEntries( List<String> entries ) {
        this.entries = entries;
    }

    public void addEntry( EntryWrapper entry ) {
        if( entries == null )
            this.entries = new ArrayList<>();
        entries.add(entry.getResourceLocation().toString());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }
}
