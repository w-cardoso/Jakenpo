package br.com.kotlinaula.jokenpo.di

import br.com.kotlinaula.jokenpo.api.JokenpoService
import br.com.kotlinaula.jokenpo.api.interceptor.AuthInterceptor
import br.com.kotlinaula.jokenpo.repository.JokenpoRepository
import br.com.kotlinaula.jokenpo.repository.JokenpoRepositoryImpl
import br.com.kotlinaula.jokenpo.view.about.AboutViewModel
import br.com.kotlinaula.jokenpo.view.game.GameViewModel
import br.com.kotlinaula.jokenpo.view.game_over.GameOverViewModel
import br.com.kotlinaula.jokenpo.view.menu.MainViewModel
import br.com.kotlinaula.jokenpo.view.ranking.RankingViewModel
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netWorkModule = module {
    single<Interceptor> { AuthInterceptor() }
    single { createOkhttpClientAuth(get()) }
    single { createNetworkClient(get()).create(JokenpoService::class.java) }
}

val repositoryModule = module {
    single<JokenpoRepository> { JokenpoRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { GameViewModel(get()) }
    viewModel { GameOverViewModel(get()) }
    viewModel { AboutViewModel(get()) }
    viewModel { RankingViewModel(get()) }

}

private fun createOkhttpClientAuth(authInterceptor: Interceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addNetworkInterceptor(StethoInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
    return builder.build()
}

private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://gamestjd.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}