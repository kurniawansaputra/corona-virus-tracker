package com.example.coronavirustracker.model

import com.google.gson.annotations.SerializedName

data class CaseInProvinceResponse(

	@field:SerializedName("missing_data")
	val missingData: Int,

	@field:SerializedName("tanpa_provinsi")
	val tanpaProvinsi: Int,

	@field:SerializedName("current_data")
	val currentData: Int,

	@field:SerializedName("list_data")
	val listData: List<ListDataItem>,

	@field:SerializedName("last_date")
	val lastDate: String
)

data class Lokasi(

	@field:SerializedName("lon")
	val lon: Double,

	@field:SerializedName("lat")
	val lat: Double
)

data class JenisKelaminItem(

	@field:SerializedName("doc_count")
	val docCount: Int,

	@field:SerializedName("key")
	val key: String
)

data class Usia(

	@field:SerializedName("value")
	val value: Int
)

data class KelompokUmurItem(

	@field:SerializedName("usia")
	val usia: Usia,

	@field:SerializedName("doc_count")
	val docCount: Int,

	@field:SerializedName("key")
	val key: String
)

data class PenambahanKasus(

	@field:SerializedName("meninggal")
	val meninggal: Int,

	@field:SerializedName("positif")
	val positif: Int,

	@field:SerializedName("sembuh")
	val sembuh: Int
)

data class ListDataItem(

	@field:SerializedName("penambahan")
	val penambahan: PenambahanKasus,

	@field:SerializedName("doc_count")
	val docCount: Double,

	@field:SerializedName("lokasi")
	val lokasi: Lokasi,

	@field:SerializedName("jumlah_meninggal")
	val jumlahMeninggal: Int,

	@field:SerializedName("kelompok_umur")
	val kelompokUmur: List<Any>,

	@field:SerializedName("jumlah_kasus")
	val jumlahKasus: Int,

	@field:SerializedName("jumlah_sembuh")
	val jumlahSembuh: Int,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: List<Any>,

	@field:SerializedName("key")
	val key: String,

	@field:SerializedName("jumlah_dirawat")
	val jumlahDirawat: Int
)
