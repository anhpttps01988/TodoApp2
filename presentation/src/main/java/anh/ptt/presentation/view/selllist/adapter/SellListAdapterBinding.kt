package anh.ptt.presentation.view.selllist.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import anh.ptt.domain.entities.SellEntity
import anh.ptt.presentation.R

object SellListAdapterBinding {

    @JvmStatic
    @BindingAdapter("name")
    fun bindSellName(textView: TextView, data: SellEntity) {
        textView.text = textView.context.getString(R.string.name, data.name)
    }

    @JvmStatic
    @BindingAdapter("price")
    fun bindSellPrice(textView: TextView, data: SellEntity) {
        textView.text = textView.context.getString(R.string.price, data.price.toFloat())
    }

    @JvmStatic
    @BindingAdapter("quantity")
    fun bindSellQuantity(textView: TextView, data: SellEntity) {
        textView.text = textView.context.getString(R.string.quantity, data.quantity)
    }
}