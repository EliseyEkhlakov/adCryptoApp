package com.adorly.cryptoapp.data.network

import com.adorly.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.adorly.cryptoapp.data.network.model.CoinNamesListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/totalvolfull")
    suspend fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit:Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym:String = CURRENCY
    ): CoinNamesListDto

    @GET("pricemultifull")
    suspend fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = API_KEY,
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms:String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms:String = CURRENCY,
    ):CoinInfoJsonContainerDto

    companion object{
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"

        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        private const val CURRENCY = "USD"
        private const val API_KEY = "6af2ac73332d1d82c4202c498cdb3b8235238bb4fd417d9442968c84a283c08f"
    }
}