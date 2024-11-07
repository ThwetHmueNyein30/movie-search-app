object UrlConfig {

    interface Names {
        companion object {
            const val BASE_URL = "BASE_URL"
            const val ENABLE_LOGGER = "ENABLE_LOGGER"
            const val API_KEY ="API_KEY"

        }
    }

    interface Dev {
        companion object {
            const val BASE_URL = "\"http://www.omdbapi.com/\""
            const val API_KEY = "\"8d6aa4ca\""

        }
    }


    interface Prod {
        companion object {
            const val BASE_URL = "\"http://www.omdbapi.com/\""
            const val API_KEY = "\"8d6aa4ca\""


        }
    }
}
