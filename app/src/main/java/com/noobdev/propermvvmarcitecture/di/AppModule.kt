package com.noobdev.propermvvmarcitecture.di

import android.content.Context
import com.noobdev.propermvvmarcitecture.BassApplication
import com.noobdev.propermvvmarcitecture.DataCClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * As we are creating app module we will use [Singelton]
 * This will be alive as long as app is alive
 * In documentation of [Hilt] the [ApplicationComponent] was used but after the update 2.31 it is renamed to [SingletonComponent].
 * [@Singleton] this a scope, life time of dependency ho long it should live.
 * [@provides] provides a dependency we want to use
 * */
@Module
@InstallIn(SingletonComponent ::class)
object AppModule {

    /**
     * it basically tell us how create instance of class or object.
     * This will provide application context through out the app at any point of time and place.
     * it is of two type: field injection and construcor injection
     * */
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BassApplication{
        return  app as BassApplication
    }

    @Singleton
    @Provides
    fun provideRandomString():String{
        return "Random String"
    }


    fun provideDataCclass():DataCClass{
        return DataCClass("")
    }

}