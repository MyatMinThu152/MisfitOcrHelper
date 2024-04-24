package com.misfit.orc.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showToast(message : String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }




}