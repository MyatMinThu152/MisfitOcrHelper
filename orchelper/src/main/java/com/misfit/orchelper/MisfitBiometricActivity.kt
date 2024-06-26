package com.misfit.orchelper

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.misfit.orchelper.delegates.AuthenticationCallbackDelegates


open class MisfitBiometricActivity : AppCompatActivity() {
    private lateinit var biometricPrompt: BiometricPrompt
    private var mDelegates: AuthenticationCallbackDelegates? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        val executor = ContextCompat.getMainExecutor(this)
        val callback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                mDelegates?.onAuthenticationFailure("Authentication error: $errString")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                mDelegates?.onAuthenticationSuccess("Authentication succeeded!")
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                mDelegates?.onAuthenticationFailure("Authentication fail!")
            }
        }

        biometricPrompt = BiometricPrompt(this, executor, callback)

        val biometricManager = BiometricManager.from(this)
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                // showToast("Biometric hardware is available")
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                showToast("No biometric hardware available")
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                showToast("Biometric hardware is unavailable")
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                showToast("No biometrics enrolled")

            }
        }

    }

    fun biometricPrompt(delegate: AuthenticationCallbackDelegates) {
        mDelegates = delegate
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Authentication")
            .setSubtitle("Choose a biometric method")
            .setNegativeButtonText("Cancel")
            .build()

        biometricPrompt.authenticate(promptInfo)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}