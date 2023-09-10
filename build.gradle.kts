 plugins {
    //trick: for the same plugin versions in all sub-modules
     alias(libs.plugins.multiplatform).apply(false)
     alias(libs.plugins.compose).apply(false)
     alias(libs.plugins.cocoapods).apply(false)
     alias(libs.plugins.android.application).apply(false)
     alias(libs.plugins.kotlinx.serialization).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
