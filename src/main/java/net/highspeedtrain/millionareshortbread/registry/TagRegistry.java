package net.highspeedtrain.millionareshortbread.registry;

import net.highspeedtrain.millionareshortbread.MillionareShortbread;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class TagRegistry {
    public static class Fluids {
        public static final TagKey<Fluid> CARAMEL_FLUID = tag("CARAMEL_FLUID");

        private static TagKey<Fluid> tag(String name) {
            return FluidTags.create(MillionareShortbread.modPath(name));
        }
    }
}
