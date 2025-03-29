package com.example.examplemod.block;

import com.example.examplemod.TutorialMod;
import com.example.examplemod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    // Đăng ký DeferredRegister cho các Block. DeferredRegister sẽ quản lý việc đăng ký các Block vào Registry.
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    // Khai báo Block "purple_diamond_block" và đăng ký với DeferredRegister.
    public static final RegistryObject<Block> PURPLE_DIAMOND_BLOCK = registerBlock("purple_diamond_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RED_DIAMOND_BLOCK = registerBlock("red_diamond_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    // Hàm này đăng ký một Block mới và tự động tạo một BlockItem (để có thể sử dụng trong inventory của người chơi).
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        // Đăng ký Block vào DeferredRegister.
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        // Gọi hàm registerBlockItem để đăng ký BlockItem tương ứng với Block vừa đăng ký.
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Hàm này đăng ký một BlockItem tương ứng với Block đã đăng ký.
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        // Đăng ký BlockItem vào DeferredRegister của ModItems (Để người chơi có thể cầm và sử dụng Block trong game).
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Hàm này được gọi để đăng ký tất cả các Block vào hệ thống của Minecraft khi mod được khởi chạy.
    public static void register(IEventBus iEventBus)
    {
        BLOCKS.register(iEventBus);  // Đăng ký DeferredRegister BLOCKS vào EventBus.
    }
}



// Luồng chạy của ứng dụng:

// 1. Khi mod được khởi tạo, hệ thống sẽ gọi phương thức `ModBlocks.register(IEventBus iEventBus)`.
// 2. Trong phương thức `register`, DeferredRegister BLOCKS sẽ được đăng ký vào EventBus.
//    - Điều này giúp hệ thống nhận diện các Block được định nghĩa trong mod khi game khởi động.
// 3. Tiếp theo, phương thức `registerBlock` sẽ được gọi để đăng ký một Block mới, trong trường hợp này là "purple_diamond_block".
//    - Phương thức này nhận tên Block và một Supplier<T> (hàm khởi tạo Block), và trả về một đối tượng `RegistryObject<Block>`.
// 4. Sau khi Block được đăng ký thành công, phương thức `registerBlockItem` sẽ được gọi để tạo và đăng ký một BlockItem tương ứng với Block.
//    - BlockItem là một đối tượng cho phép người chơi có thể cầm và sử dụng Block trong inventory, hoặc đặt Block trong thế giới.
// 5. Khi Block và BlockItem đã được đăng ký, hệ thống sẽ nhận diện và cho phép sử dụng "purple_diamond_block" trong game.

// Tóm lại, khi mod được khởi chạy:
// - Các Block được đăng ký vào hệ thống registry của Minecraft thông qua DeferredRegister.
// - Các BlockItem tương ứng được đăng ký để người chơi có thể sử dụng Block trong game.
