/*
 * Copyright 2026 Proify, Tomakino
 * Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package io.github.proify.lyricon.xposed

import android.content.Context
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedHelpers
import io.github.proify.lyricon.app.bridge.AppBridge
import io.github.proify.lyricon.xposed.systemui.Directory

object AppHooker : BaseHooker() {

    override fun onHook() {
        val preferenceDirectory = Directory.preferenceDirectory

        XposedHelpers.findAndHookMethod(
            AppBridge::class.java.name,
            classLoader,
            "isModuleActive",
            XC_MethodReplacement.returnConstant(true)
        )

        XposedHelpers.findAndHookMethod(
            AppBridge::class.java.name,
            classLoader,
            "getPreferenceDirectory",
            Context::class.java,
            XC_MethodReplacement.returnConstant(preferenceDirectory)
        )
    }
}