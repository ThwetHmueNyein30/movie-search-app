import com.android.build.api.dsl.VariantDimension

plugins {
    alias(appPlugins.plugins.com.android.application)
    alias(appPlugins.plugins.org.jetbrains.kotlin.android)
    alias(appPlugins.plugins.compose.compiler)
    alias(appPlugins.plugins.kotlin.parcelize)
    alias(appPlugins.plugins.kotlin.ksp)
    alias(appPlugins.plugins.hilt.android)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = ConfigData.NAMESPACE
    compileSdk = ConfigData.COMPILE_SDK

    defaultConfig {
        applicationId = ConfigData.APPLICATION_ID
        minSdk = ConfigData.MIN_SDK
        targetSdk = ConfigData.TARGET_SDK
        multiDexEnabled = true
        testInstrumentationRunner = ConfigData.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName(ConfigData.DEBUG) {
            buildConfigBoolean(key = UrlConfig.Names.ENABLE_LOGGER, value = "true")
            isMinifyEnabled = false
            isDebuggable = true
            isShrinkResources = false
            isJniDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        getByName(ConfigData.RELEASE) {
            buildConfigBoolean(key = UrlConfig.Names.ENABLE_LOGGER, value = "false")
            isMinifyEnabled = false
            isDebuggable = false
            isShrinkResources = false
            isJniDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += ConfigData.Flavors.FLAVOR

    productFlavors {
        create(ConfigData.Flavors.DEV) {
            applicationIdSuffix = ConfigData.Flavors.APP_ID_SUFFIX_DEV
            dimension = ConfigData.Flavors.FLAVOR
            versionCode = ConfigData.DevVersion.VERSION_CODE
            versionName = ConfigData.DevVersion.VERSION_NAME
            buildConfigString(key = UrlConfig.Names.BASE_URL, value = UrlConfig.Dev.BASE_URL)
            buildConfigString(key = UrlConfig.Names.API_KEY , value= UrlConfig.Dev.API_KEY)
        }

        create(ConfigData.Flavors.PROD) {
            dimension = ConfigData.Flavors.FLAVOR
            versionCode = ConfigData.ProdVersion.VERSION_CODE
            versionName = ConfigData.ProdVersion.VERSION_NAME
            buildConfigString(key = UrlConfig.Names.BASE_URL, value = UrlConfig.Prod.BASE_URL)
            buildConfigString(key = UrlConfig.Names.API_KEY , value= UrlConfig.Prod.API_KEY)


        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = ConfigData.KOTLIN_VERSION
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ConfigData.KOTLIN_COMPILER_VERSION
    }
    packaging {
        resources {
            excludes += ConfigData.EXCLUDE_PATH
        }
    }
}

dependencies {
    // Basic AndroidX and Compose Sdk's
    implementation(libs.core.ktx)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.lifecycle)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.preview)
    implementation(libs.compose.material3)


    //Compose navigation and Viewmodel
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)


    //Hilt Android
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    //Retrofit and logging interceptor, okhttp
    implementation(libs.retrofit)
    implementation(libs.moshi)
    implementation(libs.retrofit2.converter.moshi)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)


    //Coil
    implementation(libs.coil)
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)


    //Testing Sdk's
    testImplementation(libs.junit.junit.test)
    androidTestImplementation(libs.androidx.test.ext.test)
    androidTestImplementation(libs.androidx.test.espresso.test)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling.test)
    debugImplementation(libs.compose.ui.manifest.test)

    // timer log
    implementation(libs.utils.timber)
    
    implementation(libs.kotlinx.collections.immutable)

}

fun VariantDimension.buildConfigBoolean(key: String, value: String) {
    buildConfigField("Boolean", key, value)
}

fun VariantDimension.buildConfigString(key: String, value: String) {
    buildConfigField("String", key, value)
}

