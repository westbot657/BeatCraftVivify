#![allow(non_snake_case, static_mut_refs)]
use java_jni_extras::java_class_decl;
use jni::{jni_str, jni_sig};

java_class_decl! {
    package com.westbot.beatcraftVivify.interop;

    class VivifyNative {
        static void logInfo(String msg);
        static void logWarn(String msg);
        static void logCritical(String msg);
        static void logDebug(String msg);
    }

}

