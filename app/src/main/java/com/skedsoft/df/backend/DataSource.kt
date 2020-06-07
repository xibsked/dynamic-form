package com.skedsoft.df.backend

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.skedsoft.df.form.Form
import java.lang.reflect.Type


class DataSource private constructor(context: Context) {
    private val assetManager: AssetManager = context.assets
    private val gson: Gson = Gson();

    companion object {
        private var instance: DataSource? = null
        fun getInstance(context: Context): DataSource? {
            return if (instance == null) DataSource(
                context
            ).also { instance = it } else instance
        }
    }

    fun getForm(): Form {
        val form = gson.fromJson(assetManager.open("form.json").reader(), Form::class.java)
        return form
    }

}
