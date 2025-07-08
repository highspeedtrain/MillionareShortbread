package net.highspeedtrain.millionareshortbread.registry;

import net.highspeedtrain.millionareshortbread.MillionareShortbread;
import net.highspeedtrain.millionareshortbread.core.item.FoodProps;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MillionareShortbread.MOD_ID);

    //
    public static final RegistryObject<Item> MILLIONARE_SHORTBREAD = ITEMS.register("millionare_shortbread", () ->
        new Item(new Item.Properties().food(FoodProps.MILLIONARE_SHORTBREAD))
    );

    public static final RegistryObject<Item> CARAMEL_BUCKET = ITEMS.register("caramel_bucket", () ->
        new BucketItem(FluidRegistry.SOURCE_CARAMEL, new Item.Properties()
            .craftRemainder(Items.BUCKET)
            .stacksTo(1)
        )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
