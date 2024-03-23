/*
 * Copyright (C) 2024 Kevin Buzeau
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.buzbuz.gradle.buildlogic

import com.buzbuz.gradle.buildlogic.extensions.android

import com.buzbuz.gradle.buildlogic.extensions.getLibrary
import com.buzbuz.gradle.buildlogic.extensions.getPlugin
import com.buzbuz.gradle.buildlogic.extensions.libs
import com.buzbuz.gradle.buildlogic.extensions.plugins
import com.buzbuz.gradle.buildlogic.extensions.testImplementation

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidUnitTestConventionPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = with(target) {
        plugins {
            apply(libs.getPlugin("jetbrainsKotlinAndroid"))
        }

        android {
            defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            testOptions.unitTests.isIncludeAndroidResources = true
        }

        dependencies {
            testImplementation(libs.getLibrary("junit"))
            testImplementation(libs.getLibrary("androidx.test.core"))
            testImplementation(libs.getLibrary("androidx.test.ext.junit"))
            testImplementation(libs.getLibrary("mockito.core"))
            testImplementation(libs.getLibrary("mockito.kotlin"))
            testImplementation(libs.getLibrary("robolectric"))
        }
    }
}