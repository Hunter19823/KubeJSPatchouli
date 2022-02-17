package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import net.minecraft.resources.ResourceLocation;

import static pie.ilikepiefoo2.kubejsdocumentation.Kubejsdocumentation.MOD_ID;

public class CategoryWrapper implements PatchouliFile<CategoryWrapper> {
    public String name;
    public String description;
    public String icon;
    public String parent;
    public String flag;
    public int sortnum = 0;
    public boolean secret = false;

    public CategoryWrapper( String name, String description, String icon ) {
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    @Override
    public String getFileName() {
        return name.toLowerCase();
    }

    @Override
    public String getLocalPath() {
        return "en_us/categories/" + getFileName() + getFileType();
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return new ResourceLocation( MOD_ID, getFileName() );
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon( String icon ) {
        this.icon = icon;
    }

    public String getParent() {
        return parent;
    }

    public void setParent( String parent ) {
        this.parent = parent;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag( String flag ) {
        this.flag = flag;
    }

    public int getSortnum() {
        return sortnum;
    }

    public void setSortnum( int sortnum ) {
        this.sortnum = sortnum;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret( boolean secret ) {
        this.secret = secret;
    }
}
