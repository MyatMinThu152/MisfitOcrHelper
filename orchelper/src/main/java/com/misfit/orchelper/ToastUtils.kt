package com.misfit.orchelper

import android.content.Context
import android.hardware.biometrics.BiometricPrompt
import android.widget.Toast

class ToastUtils {
    private lateinit var biometricPrompt: BiometricPrompt
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

 

}