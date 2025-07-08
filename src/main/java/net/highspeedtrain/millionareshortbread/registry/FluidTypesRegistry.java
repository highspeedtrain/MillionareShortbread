package net.highspeedtrain.millionareshortbread.registry;

import org.joml.Vector3f;

import net.highspeedtrain.millionareshortbread.MillionareShortbread;
import net.highspeedtrain.millionareshortbread.core.fluid.BaseFluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class FluidTypesRegistry {
    @SuppressWarnings("removal")
    public static final ResourceLocation CARAMEL_STILL_RL = new ResourceLocation("block/caramel_still");
    @SuppressWarnings("removal")
    public static final ResourceLocation CARAMEL_FLOWING_RL = new ResourceLocation("block/caramel_still");
    public static final ResourceLocation CARAMEL_OVERLAY_RL = MillionareShortbread.modPath("misc/in_caramel");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MillionareShortbread.MOD_ID);

    public static final RegistryObject<FluidType> CARAMEL_FLUID_TYPE = register("caramel_fluid", 
        FluidType.Properties.create()
            .supportsBoating(true)
            .lightLevel(3)
            .viscosity(5)
            .density(50)
            .sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)
    );

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(
            CARAMEL_STILL_RL, 
            CARAMEL_FLOWING_RL, 
            CARAMEL_OVERLAY_RL, 
            0xA1E03800, 
            new Vector3f(224f / 255f, 56f / 255f, 208f / 255f), 
            properties
        ));
    }

    public static void register(IEventBus modEventBus) {
        FLUID_TYPES.register(modEventBus);
    }
}
