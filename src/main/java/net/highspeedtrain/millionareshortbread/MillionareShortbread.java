package net.highspeedtrain.millionareshortbread;

import net.highspeedtrain.millionareshortbread.registry.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;

import org.slf4j.Logger;

@Mod(MillionareShortbread.MOD_ID)
public class MillionareShortbread {
    public static final String MOD_ID = "millionareshortbread";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public MillionareShortbread() {
        @SuppressWarnings("removal")
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        CreativeTab.register(modEventBus);

        FluidRegistry.register(modEventBus);
        FluidTypeRegistry.register(modEventBus);
    }

    public static ResourceLocation modPath(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.SOURCE_CARAMEL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FluidRegistry.FLOWING_CARAMEL.get(), RenderType.translucent());
        }
    }
}
