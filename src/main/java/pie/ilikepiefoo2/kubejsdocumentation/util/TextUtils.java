package pie.ilikepiefoo2.kubejsdocumentation.util;

import pie.ilikepiefoo2.kubejsdocumentation.wrapper.CategoryWrapper;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.EntryWrapper;

import java.awt.Color;


public class TextUtils {

    public static String clearFormatting(String text) {
        return text+"$()";
    }

    public static String breakLine(String text){
        return text+"$(br)";
    }

    public static String newParagraph(String text){
        return text+"$(br2)";
    }

    public static String bulletPoint(String text, int level){
        if (level == 0) {
            return text + "$(li)";
        } else if(level > 0) {
            return text + "$(li" + level + ")";
        } else {
            return text + "$(li)";
        }
    }

    public static String color( String text, Color color){
        return text + "$(#" +
                Integer.toHexString(color.getRed()) +
                Integer.toHexString(color.getGreen()) +
                Integer.toHexString(color.getBlue()) +
                ")";
    }

    public static String colorFormat( String text, MinecraftColorFormat format){
        return text + "$(" +
                format.FORMAT_CHAR +
                ")";
    }

    public static String embedLink( String text, String entry_id) {
        return text + "$(l:" +
                entry_id +
                ")";
    }

    public static String embedLink( String text, EntryWrapper entry) {
        return text + "$(l:" +
                entry.getResourceLocation().toString() +
                ")";
    }

    public static String embedLink( String text, CategoryWrapper category) {
        return text + "$(l:" +
                category.getResourceLocation().toString() +
                ")";
    }

    public static String playername( String text) {
        return text + "$(playername)";
    }

    public static String tooltip( String text, String tooltip){
        return text + "$(t:" +
                tooltip +
                ")";
    }

    public static String endTooltip( String text){
        return text + "$(\\t)";
    }

    public static String command( String text, String command){
        return text + "$(c:" +
                command +
                ")";
    }

    public static String endCommand( String text){
        return text + "$(\\c)";
    }

}
