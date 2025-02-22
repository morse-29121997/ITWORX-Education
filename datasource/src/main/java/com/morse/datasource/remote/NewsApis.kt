package com.morse.datasource.remote

import com.morse.datasource.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApis {
    @GET("everything")
    suspend fun getAll(
        @Query("q") searchText : String?=null ,
        @Query("page") page : Int ,
        @Query("category") category : ArrayList<String> ,
        @Query("pageSize") pageSize : Int ,
    ) : Response<NewsResponse>
    @GET("everything")

    suspend fun getTopHeadline(
        @Query("q") searchText : String?=null ,
        @Query("country") country : String ,
        @Query("category") category : ArrayList<String> ,
        @Query("page") page : Int ,
        @Query("pageSize") pageSize : Int ,
    ) : Response<NewsResponse>
}