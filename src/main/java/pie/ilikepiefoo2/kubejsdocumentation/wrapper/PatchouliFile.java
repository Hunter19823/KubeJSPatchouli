package pie.ilikepiefoo2.kubejsdocumentation.wrapper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import java.util.Arrays;
import java.util.Collection;

import static pie.ilikepiefoo2.kubejsdocumentation.Kubejsdocumentation.MOD_ID;

public interface PatchouliFile<T> {
    default JsonObject toJSON(){
        JsonObject json = new JsonObject();
        Arrays.stream(this.getClass().getFields()).iterator().forEachRemaining(field -> {
            try{
                if(field.get(this) != null) {
                    if (field.getType().isArray() || Iterable.class.isAssignableFrom(field.getType())){
                        JsonArray jsonArray = new JsonArray();
                        for(Object obj : (Iterable) field.get(this)){
                            addJsonArray(obj, jsonArray);
                        }
                        json.add(field.getName(), jsonArray);
                    }
                    else {
                        json.addProperty(field.getName(), field.get(this).toString());
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        return json;
    };

    private static void addJsonArray(Object item, JsonArray jsonArray){
        if(item instanceof PatchouliFile){
            jsonArray.add(((PatchouliFile) item).toJSON());
        }else if(item instanceof JsonElement){
            jsonArray.add((JsonElement) item);
        } if(item instanceof Boolean){
            jsonArray.add((Boolean) item);
        }else if(item instanceof Number){
            jsonArray.add((Number) item);
        }else if(item instanceof String){
            jsonArray.add((String) item);
        }else if(item instanceof Character){
            jsonArray.add((Character) item);
        }
    }

    default String getLocalPath() {
        return "en_us/"+getFileName().toLowerCase()+getFileType();
    }

    String getFileName();

    default String getFileType() {
        return ".json";
    }

    ResourceLocation getResourceLocation();
}
