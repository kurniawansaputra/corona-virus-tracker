package com.example.coronavirustracker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coronavirustracker.api.ApiConfig
import com.example.coronavirustracker.model.HospitalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalViewModel : ViewModel() {
    private val _hospital = MutableLiveData<List<HospitalResponse>>()
    val hospital: LiveData<List<HospitalResponse>> = _hospital

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getHospital()
    }

    private fun getHospital() {
        _isLoading.value = true
        val client = ApiConfig.getApiService2().getHospital()
        client.enqueue(object : Callback<List<HospitalResponse>> {
            override fun onResponse(call: Call<List<HospitalResponse>>, response: Response<List<HospitalResponse>>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _hospital.value = response.body() as List<HospitalResponse>
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<HospitalResponse>>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    companion object {
        private const val TAG = "HospitalViewModel"
    }
}