package com.owl_laugh_at_wasted_time.simplenotepadcompose.di

import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.model.InNoteRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.model.InShopRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.data.model.InToDoRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.NoteRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ShoppingRepository
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.repositores.ToDoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindShoppingRepository(repository: InShopRepository): ShoppingRepository

    @Binds
    fun bindToDoRepository(repository: InToDoRepository): ToDoRepository

    @Binds
    fun bindNoteRepository(repository: InNoteRepository): NoteRepository
}