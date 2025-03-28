package com.example.examplemod.item;

import com.example.examplemod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // The DeferredRegister is a special class that allows us to register our items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

        public static final RegistryObject<Item> PURPLE_DIAMOND = ITEMS.register("purple_diamond",
            () ->new Item(new Item.Properties()));

    // This is a simple item that we will register
    public static void register(IEventBus iEventBus){
        ITEMS.register(iEventBus);
    }
}
