package com.westbot.beatcraftVivify.interop;

import com.westbot.beatcraftVivify.BeatcraftVivify;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class VivifyNative {

    static {
        loadNativeLibrary();
    }

    private static void loadNativeLibrary() {
        var os = System.getProperty("os.name").toLowerCase();
        String resourcePath;
        String suffix;
        if (os.contains("win")) {
            resourcePath = "/natives/beatcraft_vivify.dll";
            suffix = ".dll";
        } else {
            resourcePath = "/natives/beatcraft_vivify.so";
            suffix = ".so";
        }

        try (var stream = VivifyNative.class.getResourceAsStream(resourcePath)) {
            if (stream == null) throw new RuntimeException("Native library not found: " + resourcePath);

            var temp = File.createTempFile("beatcraft_vivify", suffix);
            temp.deleteOnExit();

            Files.copy(stream, temp.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.load(temp.getAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException("Failed to load native Turing library", e);
        }
    }

    @SuppressWarnings("unused")
    private static void logInfo(String msg) {
        BeatcraftVivify.LOGGER.info("[Native]: {}", msg);
    }

    @SuppressWarnings("unused")
    private static void logWarn(String msg) {
        BeatcraftVivify.LOGGER.warn("[Native]: {}", msg);
    }

    @SuppressWarnings("unused")
    private static void logCritical(String msg) {
        BeatcraftVivify.LOGGER.error("[Native]: {}", msg);
    }

    @SuppressWarnings("unused")
    private static void logDebug(String msg) {
        BeatcraftVivify.LOGGER.debug("[Native]: {}", msg);
    }

}
