package com.westbot.beatcraftVivify.neoforge;

import com.westbot.beatcraftVivify.BeatcraftVivify;
import net.neoforged.fml.common.Mod;

@Mod(BeatcraftVivify.MOD_ID)
public final class BeatcraftVivifyNeoForge {
    public BeatcraftVivifyNeoForge() {
        // Run our common setup.
        BeatcraftVivify.init();
    }
}
