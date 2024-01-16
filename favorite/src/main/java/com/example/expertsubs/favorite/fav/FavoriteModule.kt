package com.example.expertsubs.favorite.fav

import android.content.Context
import com.example.expertsubs.di.FavoriteModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteModule {

    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {

        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteModule
    }
}