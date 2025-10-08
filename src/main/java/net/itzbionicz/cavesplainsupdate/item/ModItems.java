package net.itzbionicz.cavesplainsupdate.item;

import net.itzbionicz.cavesplainsupdate.CpuMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CpuMod.MOD_ID);

    //public static final DeferredItem<Item> FARVINITE_INGOT = ITEMS.register("farvinite_ingot",
          //  () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

