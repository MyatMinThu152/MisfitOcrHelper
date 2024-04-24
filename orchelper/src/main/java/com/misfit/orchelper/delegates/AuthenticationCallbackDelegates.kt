package com.misfit.orchelper.delegates

interface AuthenticationCallbackDelegates {
    fun onAuthenticationSuccess(message: String)
    fun onAuthenticationFailure(message: String)
}