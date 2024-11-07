
object ConfigData {
    const val COMPILE_SDK = 35
    const val MIN_SDK = 26
    const val TARGET_SDK = 35


    const val NAMESPACE = "com.thn.codingassessment.android"

    const val EXCLUDE_PATH = "/META-INF/{AL2.0,LGPL2.1}"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"


    const val DEBUG = "debug"
    const val RELEASE = "release"

    const val KOTLIN_VERSION = "17"
    const val KOTLIN_COMPILER_VERSION = "1.5.12"

    const val APPLICATION_ID = "com.thn.codingassessment.android"


    interface Flavors {
        companion object {
            const val FLAVOR = "flavor"
            const val APP_ID_SUFFIX_DEV = ".dev"
            const val DEV = "DEV_"
            const val PROD = "PROD_"
        }
    }

    interface DevVersion {
        companion object {
            private const val MAJOR = 0
            private const val MINOR = 0
            private const val PATCH = 1

            val VERSION_CODE: Int
                get() = getVersionCode(MAJOR, MINOR, PATCH)

            val VERSION_NAME: String
                get() = getVersionName(MAJOR, MINOR, PATCH)
        }
    }


    interface ProdVersion {
        companion object {
            private const val MAJOR = 0
            private const val MINOR = 0
            private const val PATCH = 1

            val VERSION_CODE: Int
                get() = getVersionCode(MAJOR, MINOR, PATCH)

            val VERSION_NAME: String
                get() = getVersionName(MAJOR, MINOR, PATCH)
        }
    }

    fun getVersionCode(major: Int, minor: Int, patch: Int) = major * 10000 + minor * 100 + patch

    fun getVersionName(major: Int, minor: Int, patch: Int) =
        (major * 10000 + minor * 100 + patch).toString()
}
