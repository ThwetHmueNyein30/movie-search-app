package com.thn.codingassessment.android.core.provider

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf

class KeyboardManager(
    private val activity: Activity,
) {
    private var isKeyboardOpenState = mutableStateOf(false)

    private val inputMethodManager: InputMethodManager? =
        activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?

    init {
        val rootView = activity.findViewById<View>(android.R.id.content)
        rootView.viewTreeObserver.addOnGlobalLayoutListener {
            val rect = android.graphics.Rect()
            rootView.getWindowVisibleDisplayFrame(rect)
            val screenHeight = rootView.height
            val keypadHeight = screenHeight - rect.bottom
            isKeyboardOpenState.value = keypadHeight > screenHeight * 0.15
        }
    }


    fun hideKeyboard() {
        inputMethodManager?.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
    }
}


val LocalKeyBoardManager = staticCompositionLocalOf<KeyboardManager> {
    error("No TgKeyboardManager provided")
}


