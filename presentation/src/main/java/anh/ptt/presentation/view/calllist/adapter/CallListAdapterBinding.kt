package anh.ptt.presentation.view.calllist.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import anh.ptt.domain.entities.CallEntity
import anh.ptt.presentation.R

object CallListAdapterBinding {

    @JvmStatic
    @BindingAdapter("name")
    fun bindCallName(textView: TextView, data: CallEntity) {
        textView.text = textView.context.getString(R.string.name, data.name)
    }

    @JvmStatic
    @BindingAdapter("number")
    fun bindCallNumber(textView: TextView, data: CallEntity) {
        textView.text = textView.context.getString(R.string.number, data.number)
    }

}