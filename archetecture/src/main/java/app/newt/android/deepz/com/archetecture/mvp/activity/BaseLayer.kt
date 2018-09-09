package app.newt.android.deepz.com.archetecture.mvp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import app.newt.android.deepz.com.archetecture.mvp.utils.isEmpty


open class BaseLayer : AppCompatActivity() {
    private var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    final fun showDialog(title: String, message: String, firstButtonMessage: String, secondButtonMessage: String, firstButtonListener: DialogInterface.OnClickListener, secondButtonListener: DialogInterface.OnClickListener) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setCancelable(false)
        if (!isEmpty(firstButtonMessage)) {
            builder.setPositiveButton(firstButtonMessage, firstButtonListener)
        }
        if (!isEmpty(secondButtonMessage)) {
            builder.setNegativeButton(secondButtonMessage, secondButtonListener)
        }
        dialog = builder.show()
    }

    override fun isFinishing(): Boolean {
        dismissDialog()
        return super.isFinishing()
    }
    final fun dismissDialog() {
        if(dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }

}
