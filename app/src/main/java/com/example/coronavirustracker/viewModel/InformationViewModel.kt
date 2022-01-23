package com.example.coronavirustracker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coronavirustracker.api.ApiConfig
import com.example.coronavirustracker.model.CaseInProvinceResponse
import com.example.coronavirustracker.model.HospitalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InformationViewModel : ViewModel() {
    private val _case = MutableLiveData<CaseInProvinceResponse>()
    val case: LiveData<CaseInProvinceResponse> = _case

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getCase()
    }

    private fun getCase() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getCaseInProvince()
        client.enqueue(object : Callback<CaseInProvinceResponse> {
            override fun onResponse(call: Call<CaseInProvinceResponse>, response: Response<CaseInProvinceResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _case.value = response.body() as CaseInProvinceResponse
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<CaseInProvinceResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    companion object {
        private const val TAG = "HospitalViewModel"
    }
}