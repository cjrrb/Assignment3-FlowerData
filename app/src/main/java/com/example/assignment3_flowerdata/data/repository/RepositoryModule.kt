package com.example.assignment3_flowerdata.data.repository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindFlowerDataRepository(
        repository: RemoteFlowerDataRepository
    ): FlowerDataRepository
}