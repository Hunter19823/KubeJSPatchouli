package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

public class EmptyPageWrapper extends PageWrapper {
    public boolean draw_filler = true;

    public EmptyPageWrapper(){
        super("patchouli:empty");
    }

    public boolean isDraw_filler() {
        return draw_filler;
    }

    public void setDraw_filler( boolean draw_filler ) {
        this.draw_filler = draw_filler;
    }
}
