package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

public class LinkPageWrapper extends TextPageWrapper {
    public String url;
    public String link_text;

    public LinkPageWrapper(String text,String url, String link_text) {
        super(text);
        this.type = "patchouli:link";
        this.url = url;
        this.link_text = link_text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public String getLink_text() {
        return link_text;
    }

    public void setLink_text( String link_text ) {
        this.link_text = link_text;
    }
}
