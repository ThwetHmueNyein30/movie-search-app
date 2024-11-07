package com.thn.codingassessment.android.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.thn.codingassessment.android.BuildConfig
import com.thn.codingassessment.android.data.remote.MovieSearchApi
import com.thn.codingassessment.android.data.utils.FlowCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val WRITE_TIME = 60L
    private const val READ_TIME = 60L
    private const val CONNECT_TIME = 60L

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): MovieSearchApi = retrofit.create(MovieSearchApi::class.java)


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(FlowCallAdapterFactory.create()).baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().writeTimeout(WRITE_TIME, TimeUnit.SECONDS)
            .readTimeout(READ_TIME, TimeUnit.SECONDS).connectTimeout(CONNECT_TIME, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return if (BuildConfig.DEBUG) HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        else HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }


}