package com.misfit.orc.localization

import android.app.Application

class MisfitApp : Application() {

    companion object {
        private var context: MisfitApp? = null
        fun getContext(): MisfitApp {
            if (context == null)
                context = MisfitApp()

            val i = context
            return i!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}