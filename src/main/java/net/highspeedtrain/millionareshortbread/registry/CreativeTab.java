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
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MillionareShortbread.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MILLIONARE_SHORTBREAD_TAB =
            CREATIVE_MODE_TABS.register("millionareshortbreadmain", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.millionareshortbread"))
                .icon(() -> new ItemStack(ItemRegistry.MILLIONARE_SHORTBREAD.get()))
                .displayItems((features, output) -> {
                    output.accept(ItemRegistry.MILLIONARE_SHORTBREAD.get());
                    output.accept(ItemRegistry.CARAMEL_BUCKET.get());
                    output.accept(ItemRegistry.SHORTBREAD.get());
                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}