package com.misfit.orc.activities

import android.os.Bundle

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.misfit.orc.R
import com.misfit.orc.adapter.HomeItemAdapter
import com.misfit.orc.databinding.ActivityMainV2Binding
import com.misfit.orc.delegates.HomeItemDelegates
import com.misfit.orc.dialogs.MainItemVO
import com.misfit.orchelper.MisfitBiometricActivity


class MainActivity : MisfitBiometricActivity(), HomeItemDelegates {

    private lateinit var binding: ActivityMainV2Binding

    private val itemList = mutableListOf<MainItemVO>()
    private val mainItemAdapter by lazy { HomeItemAdapter(this) }
   // private lateinit var biometricPrompt: BiometricPrompt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainV2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.adapter = mainItemAdapter
        initData()
       // initLayout()

    }

/*    private fun initLayout() {
        val executor = ContextCompat.getMainExecutor(this)
        val callback = object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                showToast("Authentication : $errString")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                showToast("Authentication succeeded!")
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                showToast("Authentication failed")
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

    }*/

    override fun onTapItem(data: MainItemVO) {
        when (data.id) {
            1 -> {
                biometricPrompt()
            }

            else -> {
            }
        }
    }

//    private fun checkBiometricPrompt(){
//        val promptInfo = BiometricPrompt.PromptInfo.Builder()
//            .setTitle("Biometric Authentication")
//            .setSubtitle("Choose a biometric method")
//            .setNegativeButtonText("Cancel")
//            .build()
//
//        biometricPrompt.authenticate(promptInfo)
//    }

    private fun initData() {
        itemList.clear()
        itemList.add(
            MainItemVO(
                1,
                R.drawable.ic_logo,
                getString(R.string.title_fingerprint),
                R.color.colorAboutText
            )
        )
        mainItemAdapter.setNewData(itemList)

    }
}