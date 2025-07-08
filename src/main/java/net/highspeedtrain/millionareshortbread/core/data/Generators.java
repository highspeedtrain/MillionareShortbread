package net.highspeedtrain.millionareshortbread.core.data;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.highspeedtrain.millionareshortbread.MillionareShortbread;
import net.highspeedtrain.millionareshortbread.core.data.advancement.AdvancementsGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MillionareShortbread.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Generators {
    @SubscribeEvent
    public static void GatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
            event.includeServer(), 
            new ForgeAdvancementProvider(
                packOutput, 
                lookupProvider, 
                existingFileHelper, 
                List.of(new AdvancementsGenerator())
            )
        );
    }
}
