package mumtaz.dev.telsaapp.network

import mumtaz.dev.telsaapp.model.GetAllActivityResponseItem
import mumtaz.dev.telsaapp.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("get-news")
    fun getAllNews(): Call<List<GetAllNewsResponseItem>>

    @GET("get-activiys")
    fun getAllActivity(): Call<List<GetAllActivityResponseItem>>


}