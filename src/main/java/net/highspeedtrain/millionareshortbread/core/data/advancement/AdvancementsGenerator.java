package net.highspeedtrain.millionareshortbread.core.data.advancement;

import java.util.function.Consumer;

import net.highspeedtrain.millionareshortbread.MillionareShortbread;
import net.highspeedtrain.millionareshortbread.registry.ItemRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class AdvancementsGenerator implements ForgeAdvancementProvider.AdvancementGenerator {

    @SuppressWarnings({ "unused", "removal", "null" })
    @Override
    public void generate(Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement test = Advancement.Builder.advancement()
            .display(
                new ItemStack(ItemRegistry.MILLIONARE_SHORTBREAD.get()),
                Component.translatable("advancement.millionareshortbread.millionare_shortbread.title"),
                Component.translatable("advancement.millionareshortbread.millionare_shortbread.desc"),
                new ResourceLocation("minecraft:textures/gui/advancements/backgrounds/stone.png"),
                FrameType.TASK,
                true,
                true,
                false
            )
            .addCriterion("obtain_gavel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MILLIONARE_SHORTBREAD.get()))
            .save(saver, MillionareShortbread.modPath("millionare_shortbread"), existingFileHelper);
    }
}
