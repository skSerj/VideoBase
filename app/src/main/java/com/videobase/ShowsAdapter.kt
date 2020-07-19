package com.videobase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.videobase.databinding.ItemShowBinding
import com.videobase.network.model.ShowsModel

class ShowsAdapter(
    private val shows: List<ShowsModel>
) : RecyclerView.Adapter<ShowsAdapter.ShowsViewHolder>() {

    override fun getItemCount() = shows.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ShowsViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_show,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
        holder.itemShowBinding.show = shows[position]
    }





    inner class ShowsViewHolder(
        val itemShowBinding: ItemShowBinding
    ) : RecyclerView.ViewHolder(itemShowBinding.root)
}