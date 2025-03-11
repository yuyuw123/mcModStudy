package com.sihai.testmod;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestMod.MODID)
public class TestMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "testmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    //public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    //public static final RegistryObject<Block> myblock = BLOCKS.register("myblock",()-> new Block(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.CROP)));
    //public static final RegistryObject<Item> myblockitem = ITEMS.register("myblock",()-> new BlockItem(myblock.get(), new Item.Properties()));

    //public static final RegistryObject<Item> myitem = ITEMS.register("myitem",()-> new myitem(new Item.Properties()));
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,MODID);
    //public static final DeferredRegister<Item> CHICKEN_SOUL = DeferredRegister.create(ForgeRegistries.ITEMS,MODID);

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);
    public static final RegistryObject<Item> cow_soul = ITEMS.register("cow_soul",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> chicken_soul = ITEMS.register("chicken_soul",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> sheep_soul = ITEMS.register("sheep_soul",()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> pig_soul = ITEMS.register("pig_soul",()-> new Item(new Item.Properties()));


    public static final RegistryObject<CreativeModeTab> mytab = CREATIVE_MODE_TABS.register("mytab",()-> CreativeModeTab.builder()
            .title(Component.translatable("mytab"))
            .icon(()->new ItemStack(cow_soul.get()))
            .displayItems((parm,output)-> {
                output.accept(cow_soul.get());
                output.accept(chicken_soul.get());
                output.accept(sheep_soul.get());
                output.accept(pig_soul.get());
            })
            .build());

    public TestMod()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
        //ITEMS.register(bus);
        //BLOCKS.register(bus);
        //bus.addListener(this::addCreativeTab);
        //bus.register(TestMod.class);
    }
}
