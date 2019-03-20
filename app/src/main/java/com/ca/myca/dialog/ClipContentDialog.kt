package com.ca.myca.dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ca.myca.R

class ClipContentDialog : BaseDialogFragment() {
    override fun layoutId(): Int {
        return R.layout.dialog_clipcontent
    }

    override fun initView(view: View) {
        val textView: TextView = view.findViewById(R.id.tv_content)
        arguments?.getString("title").also {
            textView.setText(it)
        }
    }

    companion object {
        fun newInstance(title: String): ClipContentDialog{
            val dialog = ClipContentDialog().also {
                it.arguments = Bundle().also {
                    it.putString("title", title)
                }
            }
            return dialog
        }
    }
}