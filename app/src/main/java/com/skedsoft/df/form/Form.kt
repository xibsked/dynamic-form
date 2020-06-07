package com.skedsoft.df.form

import com.google.gson.annotations.SerializedName

data class Form(
    @SerializedName("data")
    val fields: List<Field>
)
