package com.bangkit.ambroise.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("jwt")
	val jwt: String? = null,

	@field:SerializedName("user")
	val user: UserResponse? = null
)

data class UserResponse(

	@field:SerializedName("usia")
	val usia: Any? = null,

	@field:SerializedName("jenisDahi")
	val jenisDahi: Any? = null,

	@field:SerializedName("tipeRabut")
	val tipeRabut: Any? = null,

	@field:SerializedName("confirmed")
	val confirmed: Boolean? = null,

	@field:SerializedName("transactionID")
	val transactionID: Any? = null,

	@field:SerializedName("rekomendasiPotonganRambut")
	val rekomendasiPotonganRambut: Any? = null,

	@field:SerializedName("warnaKulit")
	val warnaKulit: Any? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("noTelpUser")
	val noTelpUser: Any? = null,

	@field:SerializedName("jenisRambut")
	val jenisRambut: Any? = null,

	@field:SerializedName("blocked")
	val blocked: Boolean? = null,

	@field:SerializedName("provider")
	val provider: String? = null,

	@field:SerializedName("bentukWajah")
	val bentukWajah: Any? = null,

	@field:SerializedName("isPakeKacamata")
	val isPakeKacamata: Any? = null,

	@field:SerializedName("tanggalLahirUser")
	val tanggalLahirUser: Any? = null,

	@field:SerializedName("jenisKelamin")
	val jenisKelamin: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
