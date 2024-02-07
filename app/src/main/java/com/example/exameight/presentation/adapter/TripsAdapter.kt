package com.example.exameight.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exameight.databinding.ItemViewpagerBinding
import com.example.exameight.presentation.extensions.loadImage
import com.example.exameight.presentation.model.TripUI

class TripsAdapter() :
    ListAdapter<TripUI, TripsAdapter.TripsViewHolder>(TripsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TripsViewHolder(
        ItemViewpagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TripsViewHolder, position: Int) {
        holder.bind()
    }

    inner class TripsViewHolder(private val binding: ItemViewpagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: TripUI

        fun bind() {
            model = currentList[adapterPosition]
            binding.apply {

                tvCity.text = model.location
                tvPrice.text = model.price
                tvRate.text = model.rate.toString()
                tvTotal.text = model.reactionCount.toString()
                tvTitle.text = model.title
                ivCover.loadImage(model.cover)

            }
            listeners()
        }

        private fun listeners() {
            binding.root.setOnClickListener {
            }
        }

    }

    class TripsDiffUtil : DiffUtil.ItemCallback<TripUI>() {
        override fun areItemsTheSame(oldItem: TripUI, newItem: TripUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TripUI, newItem: TripUI): Boolean {
            return oldItem == newItem
        }
    }
}
