package com.skedsoft.df

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import com.google.android.material.textfield.TextInputLayout
import com.skedsoft.df.form.Form

class JsonFormBuilder(private val context: Context, private val form: Form) : FormBuilder {
    override fun build(): View {
        val root = form()
        form.fields.forEach {
            val wrapper = formFieldWrapper(it.label)
            val field = formField(it.id)
            wrapper.addView(field)
            root.addView(wrapper)
        }
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
        val root = LinearLayout(context)
        val factor = context.resources.displayMetrics.density;
        val rootPadding = (16 * factor).toInt()
        root.setPadding(rootPadding, rootPadding, rootPadding, rootPadding)
        root.orientation = VERTICAL
        return root
    }
}
