package com.example.examplemod.item;

import com.example.examplemod.TutorialMod;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister <CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            //            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.EMERALD))
                    .title(Component.translatable("creativetab.1"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PURPLE_DIAMOND.get());
                        pOutput.accept(ModItems.RED_DIAMOND.get());

                        pOutput.accept(ModBlocks.PURPLE_DIAMOND_BLOCK.get( ));
                        pOutput.accept(ModBlocks.RED_DIAMOND_BLOCK.get( ));

//                        pOutput.accept(Items.DIAMOND);


                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
