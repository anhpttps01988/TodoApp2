package anh.ptt.presentation.view.selllist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import anh.ptt.domain.entities.SellEntity
import anh.ptt.presentation.R
import anh.ptt.presentation.databinding.SellItemBinding

class SellListAdapter: ListAdapter<SellEntity, SellListAdapter.SellViewHolder>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<SellEntity>() {
            override fun areItemsTheSame(oldItem: SellEntity, newItem: SellEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: SellEntity, newItem: SellEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellViewHolder {
        val binding: SellItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.sell_item, parent, false)
        return SellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SellViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class SellViewHolder(private val binding: SellItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: SellEntity) {
            binding.data = data
            binding.executePendingBindings()
        }
    }

}