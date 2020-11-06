package com.androidwcc.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidwcc.whatdidilearn.R
import com.androidwcc.whatdidilearn.entities.LearnedItem

class LearnedItemsAdapter: RecyclerView.Adapter<LearnedItemsAdapter.LearnedItemViewHolder>() {
    var data = mutableListOf<LearnedItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var removedItem : LearnedItem ? = null

    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val titleItem: TextView = itemView.findViewById(
            R.id.textView_title)
        private val descriptionItem: TextView = itemView.findViewById(R.id.textView_description)
        private val levelItem: View = itemView.findViewById(R.id.linearLayout_itemLevel)
        val buttonDelete: Button = itemView.findViewById(R.id.button_delete)

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
        val learnedItemToShow: LearnedItem = data[position]
        holder.bind(learnedItemToShow.title, learnedItemToShow.description, learnedItemToShow.understandingLevel.color)

        holder.buttonDelete.setOnClickListener {
            deleteItem(learnedItemToShow)
        }
    }

    override fun getItemCount(): Int {
        // always returns the number of items in the rendered list
        return data.size
    }

    fun deleteItem(item: LearnedItem) {
        data.remove(item)
        removedItem = item
//        data.removeAt(position)
        notifyDataSetChanged()
    }

    fun getRemoveItemPosition() : LearnedItem? {
        return removedItem;
    }

}