package com.skedsoft.df

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dynamicFormFragment = DynamicFormFragment()
        val staticFormFragment = StaticFormFragment()

        supportFragmentManager.beginTransaction().replace(R.id.container, staticFormFragment).commit()
        title = "Static Form"

        dynamicForm.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, dynamicFormFragment).commit()
            title = "Dynamic Form"
        }
        staticForm.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, staticFormFragment).commit()
            title = "Static Form"
        }
    }
}
