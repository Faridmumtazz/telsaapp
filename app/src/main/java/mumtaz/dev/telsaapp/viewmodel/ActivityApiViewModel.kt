package mumtaz.dev.telsaapp.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mumtaz.dev.telsaapp.model.GetAllActivityResponseItem
import mumtaz.dev.telsaapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityApiViewModel : ViewModel(){

    var liveDataActivityApi = MutableLiveData<List<GetAllActivityResponseItem>>()

    init {
        liveDataActivityApi = MutableLiveData()
    }

    fun getLiveActivityObserver(): MutableLiveData<List<GetAllActivityResponseItem>>{
        return liveDataActivityApi
    }

    fun getAllActivityApi(){
        ApiClient.instance.getAllActivity()
            .enqueue(object : Callback<List<GetAllActivityResponseItem>>{
                @SuppressLint("NullSafeMutableLiveData")
                override fun onResponse(
                    call: Call<List<GetAllActivityResponseItem>>,
                    response: Response<List<GetAllActivityResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataActivityApi.postValue(response.body())

                    } else{
                        liveDataActivityApi.postValue(null)
                    }
                }

                @SuppressLint("NullSafeMutableLiveData")
                override fun onFailure(call: Call<List<GetAllActivityResponseItem>>, t: Throwable) {
                    liveDataActivityApi.postValue(null)
                }

            })
    }
}