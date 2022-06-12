package com.bangkit.ambroise.core.data.remote.request

import com.google.gson.annotations.SerializedName

data class UserRequest(
    @field:SerializedName("username")
    val username: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("jenisKelamin")
    val jenisKelamin: String? = null,

    @field:SerializedName("tanggalLahirUser")
    val tanggalLahir: String? = null,

    @field:SerializedName("noTelpUser")
    val noTelp: String? = null
)