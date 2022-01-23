package com.example.coronavirustracker.api

import com.example.coronavirustracker.model.CaseInProvinceResponse
import com.example.coronavirustracker.model.HospitalResponse
import com.example.coronavirustracker.model.TotalCaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("update.json")
    fun getTotalCase(): Call<TotalCaseResponse>

    @GET("hospitals")
    fun getHospital(): Call<List<HospitalResponse>>

    @GET("prov.json")
    fun getCaseInProvince(): Call<CaseInProvinceResponse>
}