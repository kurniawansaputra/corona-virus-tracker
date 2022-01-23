package com.example.coronavirustracker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coronavirustracker.api.ApiConfig
import com.example.coronavirustracker.model.TotalCaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _total = MutableLiveData<TotalCaseResponse>()
    val total: LiveData<TotalCaseResponse> = _total

    private val _isRefresh = MutableLiveData<Boolean>()
    val isRefresh: LiveData<Boolean> = _isRefresh

    init {
        getTotal()
    }

    fun getTotal() {
        val client = ApiConfig.getApiService().getTotalCase()
        client.enqueue(object : Callback<TotalCaseResponse> {
            override fun onResponse(call: Call<TotalCaseResponse>, response: Response<TotalCaseResponse>) {
                _isRefresh.value = false
                if (response.isSuccessful) {
                    _total.value = response.body() as TotalCaseResponse
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TotalCaseResponse>, t: Throwable) {
                _isRefresh.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }
}