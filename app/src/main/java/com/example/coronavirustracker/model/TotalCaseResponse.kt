package com.example.coronavirustracker.model

import com.google.gson.annotations.SerializedName

data class TotalCaseResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("update")
	val update: Update
)

data class JumlahPositifKum(

	@field:SerializedName("value")
	val value: Int
)

data class Penambahan(

	@field:SerializedName("created")
	val created: String,

	@field:SerializedName("jumlah_meninggal")
	val jumlahMeninggal: Int,

	@field:SerializedName("tanggal")
	val tanggal: String,

	@field:SerializedName("jumlah_sembuh")
	val jumlahSembuh: Int,

	@field:SerializedName("jumlah_positif")
	val jumlahPositif: Int,

	@field:SerializedName("jumlah_dirawat")
	val jumlahDirawat: Int
)

data class Data(

	@field:SerializedName("jumlah_odp")
	val jumlahOdp: Int,

	@field:SerializedName("jumlah_pdp")
	val jumlahPdp: Int,

	@field:SerializedName("total_spesimen")
	val totalSpesimen: Int,

	@field:SerializedName("total_spesimen_negatif")
	val totalSpesimenNegatif: Int,

	@field:SerializedName("id")
	val id: Int
)

data class Update(

	@field:SerializedName("penambahan")
	val penambahan: Penambahan,

	@field:SerializedName("total")
	val total: Total,

	@field:SerializedName("harian")
	val harian: List<HarianItem>
)

data class JumlahDirawat(

	@field:SerializedName("value")
	val value: Int
)

data class JumlahDirawatKum(

	@field:SerializedName("value")
	val value: Int
)

data class Total(

	@field:SerializedName("jumlah_meninggal")
	val jumlahMeninggal: Int,

	@field:SerializedName("jumlah_sembuh")
	val jumlahSembuh: Int,

	@field:SerializedName("jumlah_positif")
	val jumlahPositif: Int,

	@field:SerializedName("jumlah_dirawat")
	val jumlahDirawat: Int
)

data class JumlahMeninggalKum(

	@field:SerializedName("value")
	val value: Int
)

data class JumlahPositif(

	@field:SerializedName("value")
	val value: Int
)

data class HarianItem(

	@field:SerializedName("key_as_string")
	val keyAsString: String,

	@field:SerializedName("doc_count")
	val docCount: Int,

	@field:SerializedName("jumlah_positif_kum")
	val jumlahPositifKum: JumlahPositifKum,

	@field:SerializedName("jumlah_sembuh_kum")
	val jumlahSembuhKum: JumlahSembuhKum,

	@field:SerializedName("jumlah_meninggal_kum")
	val jumlahMeninggalKum: JumlahMeninggalKum,

	@field:SerializedName("jumlah_meninggal")
	val jumlahMeninggal: JumlahMeninggal,

	@field:SerializedName("jumlah_sembuh")
	val jumlahSembuh: JumlahSembuh,

	@field:SerializedName("key")
	val key: Long,

	@field:SerializedName("jumlah_positif")
	val jumlahPositif: JumlahPositif,

	@field:SerializedName("jumlah_dirawat_kum")
	val jumlahDirawatKum: JumlahDirawatKum,

	@field:SerializedName("jumlah_dirawat")
	val jumlahDirawat: JumlahDirawat
)

data class JumlahMeninggal(

	@field:SerializedName("value")
	val value: Int
)

data class JumlahSembuhKum(

	@field:SerializedName("value")
	val value: Int
)

data class JumlahSembuh(

	@field:SerializedName("value")
	val value: Int
)
