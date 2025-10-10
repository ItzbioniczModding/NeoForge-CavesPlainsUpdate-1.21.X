package net.itzbionicz.cavesplainsupdate.item;

import net.itzbionicz.cavesplainsupdate.CpuMod;
import net.itzbionicz.cavesplainsupdate.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab>CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CpuMod.MOD_ID);

    public static final Supplier<CreativeModeTab> CPU_TAB = CREATIVE_MODE_TAB.register("cpu_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.HOLLOW_LOG.get()))
                    .title(Component.translatable("creativetab.cpumod.cputab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.HOLLOW_LOG);
                        output.accept(ModBlocks.STRIPPED_HOLLOW_LOG);
                        output.accept(ModBlocks.HOLLOW_WOOD);
                        output.accept(ModBlocks.STRIPPED_HOLLOW_WOOD);
                        output.accept(ModBlocks.HOLLOW_LEAVES);
                        output.accept(ModBlocks.HOLLOW_SAPLING);
                        output.accept(ModBlocks.HOLLOW_PLANK);
                        output.accept(ModBlocks.HOLLOW_STAIRS);
                        output.accept(ModBlocks.HOLLOW_SLAB);
                        output.accept(ModBlocks.HOLLOW_PRESSURE_PLATE);
                        output.accept(ModBlocks.HOLLOW_BUTTON);
                        output.accept(ModBlocks.HOLLOW_FENCE);
                        output.accept(ModBlocks.HOLLOW_FENCE_GATE);
                        output.accept(ModBlocks.HOLLOW_DOOR);
                        output.accept(ModBlocks.HOLLOW_TRAPDOOR);


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
