package pie.ilikepiefoo2.kubejsdocumentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.PatchouliFile;

import java.io.IOException;
import java.nio.file.Path;

public class PatchoiliDataProvider implements net.minecraft.data.DataProvider {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    public final DataGenerator generator;
    public final PatchouliFile<?> file;
    public PatchoiliDataProvider( DataGenerator generator, PatchouliFile file){
        this.generator = generator;
        this.file = file;
    }

    @Override
    public void run( HashCache cache ) throws IOException {
        //Path path = Path.of("data/"+Kubejsdocumentation.MOD_ID +"/patchouli_books/test/"+file.getLocalPath());
        Path path = Path.of("patchouli_books/test/"+file.getLocalPath());
        net.minecraft.data.DataProvider.save(GSON,cache, file.toJSON(), path);
    }

    @Override
    public String getName() {
        return "Patchouli Data Provider.";
    }
}
