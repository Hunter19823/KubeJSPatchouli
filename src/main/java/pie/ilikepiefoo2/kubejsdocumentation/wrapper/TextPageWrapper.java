package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

public class TextPageWrapper extends PageWrapper {
    public String text;
    public String title;

    public TextPageWrapper(String text){
        super("patchouli:text");
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }
}
