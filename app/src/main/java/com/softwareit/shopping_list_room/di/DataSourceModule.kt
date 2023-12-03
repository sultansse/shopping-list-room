package com.softwareit.shopping_list_room.di

import com.softwareit.shopping_list_room.data.source.DataSource
import com.softwareit.shopping_list_room.data.source.local.LocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindDataSourceLocal(localDataSource: LocalDataSource): DataSource.Local
}