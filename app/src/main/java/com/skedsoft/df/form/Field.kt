package com.skedsoft.df.form

data class Field(
    val id: String,
    val type: String,
    val label: String,
    val hintText: String,
    val required: String,
    val validator: List<Validator>
)
