package pie.ilikepiefoo2.kubejsdocumentation;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pie.ilikepiefoo2.kubejsdocumentation.wrapper.PatchouliFile;

import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Kubejsdocumentation.MOD_ID)
public class Kubejsdocumentation {
    public static final String MOD_ID = "kubejsdocumentation";
    public static final String MOD_NAME = "KubeJSDocumentation";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Kubejsdocumentation() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Kubejsdocumentation::onDataGather);
        LOGGER.info("Hello from Kubejsdocumentation!");

    }

    @SubscribeEvent
    public static void onDataGather( GatherDataEvent event) {
        LOGGER.info("Data Generated!");
        event.includeClient();
        event.includeServer();
        event.includeDev();
        List<PatchouliFile> patchouliFiles = TestBook.getTestBook();
        patchouliFiles.forEach(file -> event.getGenerator().addProvider(new PatchoiliDataProvider(event.getGenerator(),file)));
    }
}
