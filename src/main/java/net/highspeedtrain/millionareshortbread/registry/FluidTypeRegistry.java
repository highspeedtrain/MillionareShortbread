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

public class FluidTypeRegistry {
    public static final ResourceLocation CARAMEL_STILL_RL = MillionareShortbread.modPath("block/caramel_still");
    public static final ResourceLocation CARAMEL_FLOWING_RL = MillionareShortbread.modPath("block/caramel_flow");
    public static final ResourceLocation CARAMEL_OVERLAY_RL = MillionareShortbread.modPath("misc/in_caramel_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MillionareShortbread.MOD_ID);

    public static final RegistryObject<FluidType> CARAMEL_FLUID_TYPE = register("caramel_fluid_type",
        FluidType.Properties.create()
            .lightLevel(2)
            .density(1000)
            .viscosity(5000)
            .temperature(300)
            .supportsBoating(true)
            .sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)
    );



    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(CARAMEL_STILL_RL, CARAMEL_FLOWING_RL, CARAMEL_OVERLAY_RL,
                0xFFEB731C, 0.6f, 1f, new Vector3f(235f / 255f, 115f / 255f, 28f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}