package anh.ptt.presentation.view.buylist.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import anh.ptt.domain.entities.BuyEntity
import anh.ptt.presentation.R

object BuyListAdapterBinding {

    @JvmStatic
    @BindingAdapter("name")
    fun bindBuyName(textView: TextView, data: BuyEntity) {
        textView.text = textView.context.getString(R.string.name, data.name)
    }

    @JvmStatic
    @BindingAdapter("price")
    fun bindBuyPrice(textView: TextView, data: BuyEntity) {
        textView.text = textView.context.getString(R.string.price, data.price)
    }

    @JvmStatic
    @BindingAdapter("quantity")
    fun bindBuyQuantity(textView: TextView, data: BuyEntity) {
        textView.text = textView.context.getString(R.string.quantity, data.quantity)
    }
}