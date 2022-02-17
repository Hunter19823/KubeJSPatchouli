package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

import static pie.ilikepiefoo2.kubejsdocumentation.Kubejsdocumentation.MOD_ID;

public class EntryWrapper implements PatchouliFile<EntryWrapper> {
    public String name;
    public String category;
    public String icon;
    public List<PageWrapper> pages;
    public String advancement;
    public String flag;
    public boolean priority = false;
    public boolean secret = false;
    public boolean read_by_default = false;
    public int sortnum = 0;
    public String turnin;
    public List<String> extra_recipe_mappings;

    public EntryWrapper( String name, String category, String icon, List<PageWrapper> pages ) {
        this.name = name;
        this.category = category;
        this.icon = icon;
        this.pages = pages;
    }
    public EntryWrapper( String name, CategoryWrapper category, String icon, List<PageWrapper> pages ) {
        this(name, category.getResourceLocation().toString(), icon, pages);
    }

    @Override
    public String getFileName() {
        return name.toLowerCase();
    }

    @Override
    public String getLocalPath(){
        return "en_us/entries/"+getFileName()+getFileType();
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return new ResourceLocation(MOD_ID, getFileName());
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public void setCategory( CategoryWrapper category ) {
        this.category = category.getResourceLocation().toString();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon( String icon ) {
        this.icon = icon;
    }

    public List<PageWrapper> getPages() {
        return pages;
    }

    public void setPages( List<PageWrapper> pages ) {
        this.pages = pages;
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

    public boolean isPriority() {
        return priority;
    }

    public void setPriority( boolean priority ) {
        this.priority = priority;
    }

    public boolean isSecret() {
        return secret;
    }

    public void setSecret( boolean secret ) {
        this.secret = secret;
    }

    public boolean isRead_by_default() {
        return read_by_default;
    }

    public void setRead_by_default( boolean read_by_default ) {
        this.read_by_default = read_by_default;
    }

    public int getSortnum() {
        return sortnum;
    }

    public void setSortnum( int sortnum ) {
        this.sortnum = sortnum;
    }

    public String getTurnin() {
        return turnin;
    }

    public void setTurnin( String turnin ) {
        this.turnin = turnin;
    }

    public List<String> getExtra_recipe_mappings() {
        return extra_recipe_mappings;
    }

    public void setExtra_recipe_mappings( List<String> extra_recipe_mappings ) {
        this.extra_recipe_mappings = extra_recipe_mappings;
    }
}
