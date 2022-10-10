package mumtaz.dev.telsaapp.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mumtaz.dev.telsaapp.model.GetAllNewsResponseItem
import mumtaz.dev.telsaapp.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class NewsApiViewModel: ViewModel() {

   var liveDataNewsApi= MutableLiveData<List<GetAllNewsResponseItem>>()

    init {
        liveDataNewsApi = MutableLiveData()
    }
    fun getLiveNewsObserver(): MutableLiveData<List<GetAllNewsResponseItem>>{
        return liveDataNewsApi
    }
    fun getAllNewsApi(){

        ApiClient.instance.getAllNews()
            .enqueue(object :retrofit2.Callback<List<GetAllNewsResponseItem>>{

                @SuppressLint("NullSafeMutableLiveData")
                override fun onResponse(
                    call: Call<List<GetAllNewsResponseItem>>,
                    response: Response<List<GetAllNewsResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataNewsApi.postValue(response.body())

                    } else{
                        liveDataNewsApi.postValue(null)
                    }
                }

                @SuppressLint("NullSafeMutableLiveData")
                override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {
                    liveDataNewsApi.postValue(null)
                }

            })
    }
}