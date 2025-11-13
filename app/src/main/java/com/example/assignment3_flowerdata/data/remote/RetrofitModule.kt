package com.example.assignment3_flowerdata.data.remote



@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val BASE_URL =
        "https://tetervak.dev.fast.sheridanc.on.ca/mobile-app-data/flower-data/data/"

    @Provides
    @Singleton
    fun retrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()


    @Provides
    @Singleton
    fun flowerDataApi(retrofit: Retrofit): FlowerDataApi =
        retrofit.create(FlowerDataApi::class.java)

}