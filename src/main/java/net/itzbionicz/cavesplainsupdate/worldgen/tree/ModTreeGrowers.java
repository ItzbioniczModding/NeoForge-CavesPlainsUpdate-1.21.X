package net.itzbionicz.cavesplainsupdate.worldgen.tree;

import net.itzbionicz.cavesplainsupdate.CpuMod;
import net.itzbionicz.cavesplainsupdate.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower HOLLOW = new TreeGrower(CpuMod.MOD_ID + ":hollow",
            Optional.empty(), Optional.of(ModConfiguredFeatures.HOLLOW_KEY), Optional.empty());

}
