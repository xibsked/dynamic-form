package com.skedsoft.df

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.skedsoft.df.backend.DataSource

class DynamicFormFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = JsonFormBuilder(context!!,DataSource.getInstance(context!!)!!.getForm()).build()
        return view
    }
}
