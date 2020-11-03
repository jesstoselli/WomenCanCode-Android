package com.androidwcc.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidwcc.whatdidilearn.R
import com.androidwcc.whatdidilearn.entities.ItemLearned

class LearnedItemsAdapter: RecyclerView.Adapter<LearnedItemsAdapter.LearnedItemViewHolder>() {
    var data = listOf<ItemLearned>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val titleItem: TextView = itemView.findViewById(
            R.id.textView_title)
        private val descriptionItem: TextView = itemView.findViewById(R.id.textView_description)
        private val levelItem: View = itemView.findViewById(R.id.linearLayout_itemLevel)

        fun bind(title: String, description: String, color: Int) {
            titleItem.text = title
            descriptionItem.text = description
            levelItem.setBackgroundResource(color)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_learned, parent, false)
        return LearnedItemViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: LearnedItemViewHolder,
        position: Int
    ) {
        val itemLearnedToShow: ItemLearned = data.get(position)
        holder.bind(itemLearnedToShow.title, itemLearnedToShow.description, itemLearnedToShow.understandingLevel.color)
    }

    override fun getItemCount(): Int {
        // always returns the number of items in the rendered list
        return data.size
    }

}