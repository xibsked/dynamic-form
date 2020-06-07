package com.skedsoft.df

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.material.textfield.TextInputLayout

class JsonFormBuilder(private val context: Context) : FormBuilder {
    override fun build(): View {

        val root = form()

        val customerNameWrapper = formFieldWrapper("Name")

        val customerNameEditText = formField("customer_name")

        customerNameWrapper.addView(customerNameEditText)

        root.addView(customerNameWrapper)
        return root
    }

    private fun formFieldWrapper(label: String): ViewGroup {
        val wrapper = TextInputLayout(context)
        wrapper.layoutParams =
            LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        wrapper.isHintEnabled = true
        wrapper.hint = label
        return wrapper
    }

    private fun formField(id: String): View {
        val field = EditText(context);
        field.layoutParams =
            LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        field.tag = id
        return field
    }

    private fun form(): ViewGroup {
        val root: ViewGroup = LinearLayout(context)
        val factor = context.resources.displayMetrics.density;
        val rootPadding = (16 * factor).toInt()
        root.setPadding(rootPadding, rootPadding, rootPadding, rootPadding)
        return root
    }
}
