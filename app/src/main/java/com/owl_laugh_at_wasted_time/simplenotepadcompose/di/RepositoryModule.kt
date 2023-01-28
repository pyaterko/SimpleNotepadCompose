package com.owl_laugh_at_wasted_time.simplenotepadcompose.di

import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.InShopRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ShoppingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindShoppingRepository(repository: InShopRepository): ShoppingRepository
}