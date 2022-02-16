package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import java.util.List;

public class ImagePageWrapper extends PageWrapper {
    public List<String> images;
    public String title;
    public boolean border = false;
    public String text;

    public ImagePageWrapper(List<String> images) {
        super("patchouli:image");
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages( List<String> images ) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder( boolean border ) {
        this.border = border;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }
}
