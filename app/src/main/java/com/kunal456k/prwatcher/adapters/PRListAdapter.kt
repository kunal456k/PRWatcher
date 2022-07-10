package com.kunal456k.prwatcher.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kunal456k.prwatcher.component.ActivityScope
import com.kunal456k.prwatcher.databinding.PrItemBinding
import com.kunal456k.prwatcher.data.PullRequest
import javax.inject.Inject

val DIFF_CALLBACK =  object : DiffUtil.ItemCallback<PullRequest>() {
    override fun areItemsTheSame(oldItem: PullRequest, newItem: PullRequest) : Boolean{
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PullRequest, newItem: PullRequest) : Boolean{
        return oldItem == newItem
    }
}

@ActivityScope
class PRListAdapter @Inject constructor() : PagingDataAdapter<PullRequest, PRItemHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRItemHolder {
        Log.d("test", "onCreateViewHolder: ")
        return PRItemHolder(PrItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PRItemHolder, position: Int) {
        Log.d("test", "onBindViewHolder: ")
        holder.setPullRequest(getItem(position))
    }
}

class PRItemHolder(private val binding: PrItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setPullRequest(item: PullRequest?) {
        binding.pr = item
    }
}