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
import com.misfit.orchelper.delegates.AuthenticationCallbackDelegates


class MainActivity : MisfitBiometricActivity(), HomeItemDelegates ,
    AuthenticationCallbackDelegates {

    private lateinit var binding: ActivityMainV2Binding
    private val itemList = mutableListOf<MainItemVO>()
    private val mainItemAdapter by lazy { HomeItemAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainV2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.adapter = mainItemAdapter
        initData()


    }

    override fun onTapItem(data: MainItemVO) {
        when (data.id) {
            1 -> {
                biometricPrompt(this)
            }

            else -> {
            }
        }
    }

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
        itemList.add(
            MainItemVO(
                2,
                R.drawable.ic_logo,
                getString(R.string.title_fingerprint),
                R.color.colorAboutText
            )
        )
        mainItemAdapter.setNewData(itemList)

    }

    override fun onAuthenticationSuccess(message: String) {
        showToast(message)
    }

    override fun onAuthenticationFailure(message: String) {
      showToast(message)
    }
}