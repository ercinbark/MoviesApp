package com.ercin.movies.base

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ercin.movies.widget.LoadingDialog

open class BaseActivity : AppCompatActivity() {

    private var loadingDialog: LoadingDialog? = null

    @Synchronized
    private fun getProgressDialog(isCancelable: Boolean) {
        if (!isFinishing) {
            if (loadingDialog == null) {
                loadingDialog = LoadingDialog(this)
            }
            loadingDialog!!.setCancelable(isCancelable)
            loadingDialog!!.show()
        }
    }

    fun showFullScreenProgressDialog(isCancelable: Boolean) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            getProgressDialog(isCancelable)
        } else {
            Handler(Looper.getMainLooper()).post { getProgressDialog(isCancelable) }
        }
    }

    @Synchronized
    fun dismissFullScreenProgressDialog() {
        if (!isFinishing && loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog!!.dismiss()
        }
    }
}
