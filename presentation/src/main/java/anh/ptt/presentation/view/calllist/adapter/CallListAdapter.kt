package anh.ptt.presentation.view.calllist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import anh.ptt.domain.entities.CallEntity
import anh.ptt.presentation.R
import anh.ptt.presentation.databinding.CallItemBinding

class CallListAdapter : ListAdapter<CallEntity, CallListAdapter.CallViewHolder>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<CallEntity>() {
            override fun areItemsTheSame(oldItem: CallEntity, newItem: CallEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CallEntity, newItem: CallEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val binding: CallItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.call_item, parent, false)
        return CallViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class CallViewHolder(private val binding: CallItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: CallEntity) {
            binding.data = data
            binding.executePendingBindings()
        }
    }

}