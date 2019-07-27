package br.com.kotlinaula.jokenpo

import android.app.Application
import br.com.kotlinaula.jokenpo.di.netWorkModule
import br.com.kotlinaula.jokenpo.di.repositoryModule
import br.com.kotlinaula.jokenpo.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    netWorkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}