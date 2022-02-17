package pie.ilikepiefoo2.kubejsdocumentation.wrapper;


import net.minecraft.resources.ResourceLocation;

import static pie.ilikepiefoo2.kubejsdocumentation.Kubejsdocumentation.MOD_ID;

public class BookWrapper implements PatchouliFile<BookWrapper> {
    public String name;
    public String landing_text;
    public String book_texture = "patchouli:textures/gui/book_brown.png";
    public String filter_texture;
    public String crafting_texture;
    public String model = "patchouli:book_brown";
    public String text_color = "000000";
    public String header_color = "333333";
    public String nameplate_color = "FFDD00";
    public String link_color = "0000EE";
    public String link_hover_color = "8800EE";
    public String progress_bar_color = "FFFF55";
    public String progress_bar_background = "DDDDDD";
    public String open_sound;
    public String flip_sound;
    public String index_icon;
    public boolean show_progress = true;
    public String version = "0";
    public String creative_tab = "misc";
    public String advancements_tab;
    public boolean dont_generatebook = false;
    public String custom_book_item;
    public boolean show_toasts = true;
    public boolean use_blocky_font = false;
    public boolean i18n = false;
    public boolean pause_game = false;
    public String extend;
    public boolean allow_extensions = true;


    public BookWrapper( String name, String landing_text ) {
        this.name = name;
        this.landing_text = landing_text;
    }

    @Override
    public String getFileName() {
        return "book";
    }

    @Override
    public String getLocalPath() {
        return "book.json";
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return new ResourceLocation(MOD_ID, MOD_ID);
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getLanding_text() {
        return landing_text;
    }

    public void setLanding_text( String landing_text ) {
        this.landing_text = landing_text;
    }

    public String getBook_texture() {
        return book_texture;
    }

    public void setBook_texture( String book_texture ) {
        this.book_texture = book_texture;
    }

    public String getFilter_texture() {
        return filter_texture;
    }

    public void setFilter_texture( String filter_texture ) {
        this.filter_texture = filter_texture;
    }

    public String getCrafting_texture() {
        return crafting_texture;
    }

    public void setCrafting_texture( String crafting_texture ) {
        this.crafting_texture = crafting_texture;
    }

    public String getModel() {
        return model;
    }

    public void setModel( String model ) {
        this.model = model;
    }

    public String getText_color() {
        return text_color;
    }

    public void setText_color( String text_color ) {
        this.text_color = text_color;
    }

    public String getHeader_color() {
        return header_color;
    }

    public void setHeader_color( String header_color ) {
        this.header_color = header_color;
    }

    public String getNameplate_color() {
        return nameplate_color;
    }

    public void setNameplate_color( String nameplate_color ) {
        this.nameplate_color = nameplate_color;
    }

    public String getLink_color() {
        return link_color;
    }

    public void setLink_color( String link_color ) {
        this.link_color = link_color;
    }

    public String getLink_hover_color() {
        return link_hover_color;
    }

    public void setLink_hover_color( String link_hover_color ) {
        this.link_hover_color = link_hover_color;
    }

    public String getProgress_bar_color() {
        return progress_bar_color;
    }

    public void setProgress_bar_color( String progress_bar_color ) {
        this.progress_bar_color = progress_bar_color;
    }

    public String getProgress_bar_background() {
        return progress_bar_background;
    }

    public void setProgress_bar_background( String progress_bar_background ) {
        this.progress_bar_background = progress_bar_background;
    }

    public String getOpen_sound() {
        return open_sound;
    }

    public void setOpen_sound( String open_sound ) {
        this.open_sound = open_sound;
    }

    public String getFlip_sound() {
        return flip_sound;
    }

    public void setFlip_sound( String flip_sound ) {
        this.flip_sound = flip_sound;
    }

    public String getIndex_icon() {
        return index_icon;
    }

    public void setIndex_icon( String index_icon ) {
        this.index_icon = index_icon;
    }

    public boolean isShow_progress() {
        return show_progress;
    }

    public void setShow_progress( boolean show_progress ) {
        this.show_progress = show_progress;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion( String version ) {
        this.version = version;
    }

    public String getCreative_tab() {
        return creative_tab;
    }

    public void setCreative_tab( String creative_tab ) {
        this.creative_tab = creative_tab;
    }

    public String getAdvancements_tab() {
        return advancements_tab;
    }

    public void setAdvancements_tab( String advancements_tab ) {
        this.advancements_tab = advancements_tab;
    }

    public boolean isDont_generatebook() {
        return dont_generatebook;
    }

    public void setDont_generatebook( boolean dont_generatebook ) {
        this.dont_generatebook = dont_generatebook;
    }

    public String getCustom_book_item() {
        return custom_book_item;
    }

    public void setCustom_book_item( String custom_book_item ) {
        this.custom_book_item = custom_book_item;
    }

    public boolean isShow_toasts() {
        return show_toasts;
    }

    public void setShow_toasts( boolean show_toasts ) {
        this.show_toasts = show_toasts;
    }

    public boolean isUse_blocky_font() {
        return use_blocky_font;
    }

    public void setUse_blocky_font( boolean use_blocky_font ) {
        this.use_blocky_font = use_blocky_font;
    }

    public boolean isI18n() {
        return i18n;
    }

    public void setI18n( boolean i18n ) {
        this.i18n = i18n;
    }

    public boolean isPause_game() {
        return pause_game;
    }

    public void setPause_game( boolean pause_game ) {
        this.pause_game = pause_game;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend( String extend ) {
        this.extend = extend;
    }

    public boolean isAllow_extensions() {
        return allow_extensions;
    }

    public void setAllow_extensions( boolean allow_extensions ) {
        this.allow_extensions = allow_extensions;
    }
}
