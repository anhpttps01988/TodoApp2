package anh.ptt.presentation.view.buylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import anh.ptt.domain.entities.BuyEntity
import anh.ptt.presentation.R
import anh.ptt.presentation.databinding.BuyItemBinding

class BuyListAdapter: ListAdapter<BuyEntity, BuyListAdapter.BuyViewHolder>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<BuyEntity>() {
            override fun areItemsTheSame(oldItem: BuyEntity, newItem: BuyEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: BuyEntity, newItem: BuyEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyViewHolder {
        val binding: BuyItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.buy_item, parent, false)
        return BuyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class BuyViewHolder(private val binding: BuyItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: BuyEntity) {
            binding.data = data
            binding.executePendingBindings()
        }
    }

}