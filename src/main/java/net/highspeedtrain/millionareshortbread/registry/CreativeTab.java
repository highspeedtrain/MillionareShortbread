package net.highspeedtrain.millionareshortbread.registry;

import net.highspeedtrain.millionareshortbread.MillionareShortbread;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MillionareShortbread.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("millionareshortbreadmain",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.MILLIONARE_SHORTBREAD.get()))
                    .title(Component.translatable("creativetab.millionareshortbreadmain"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemRegistry.MILLIONARE_SHORTBREAD.get());
                        pOutput.accept(ItemRegistry.SHORTBREAD.get());
                        pOutput.accept(ItemRegistry.BUTTER.get());
                        pOutput.accept(ItemRegistry.SALT.get());

                        pOutput.accept(ItemRegistry.CARAMEL_BUCKET.get());
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}