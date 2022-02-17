package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import net.minecraft.resources.ResourceLocation;

public class PageWrapper implements PatchouliFile<PageWrapper> {
    public String type;
    public String advancement;
    public String flag;
    public String anchor;

    protected PageWrapper(String type){
        this.type = type;
    }

    @Override
    public String getFileName() {
        return type;
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getAdvancement() {
        return advancement;
    }

    public void setAdvancement( String advancement ) {
        this.advancement = advancement;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag( String flag ) {
        this.flag = flag;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor( String anchor ) {
        this.anchor = anchor;
    }
}
