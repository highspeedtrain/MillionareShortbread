package net.highspeedtrain.millionareshortbread.registry;

import net.highspeedtrain.millionareshortbread.MillionareShortbread;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidRegistry {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MillionareShortbread.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_CARAMEL = FLUIDS.register("caramel_fluid", () ->
        new ForgeFlowingFluid.Source(FluidRegistry.CARAMEL_PROPERTIES)
    );

    public static final RegistryObject<FlowingFluid> FLOWING_CARAMEL = FLUIDS.register("flowing_caramel_fluid", () ->
        new ForgeFlowingFluid.Flowing(FluidRegistry.CARAMEL_PROPERTIES)
    );

    public static final ForgeFlowingFluid.Properties CARAMEL_PROPERTIES = new ForgeFlowingFluid.Properties(FluidTypesRegistry.CARAMEL_FLUID_TYPE, 
        SOURCE_CARAMEL, FLOWING_CARAMEL)
        .levelDecreasePerBlock(3)
        .slopeFindDistance(3)
        .block(BlockRegistry.CARAMEL_BLOCK)
        .bucket(ItemRegistry.CARAMEL_BUCKET)
    ;

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
