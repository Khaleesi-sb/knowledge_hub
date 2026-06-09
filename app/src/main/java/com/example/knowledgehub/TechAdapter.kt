package com.example.knowledgehub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TechAdapter(
    private val technologies: List<TechPojo>,
    private val onItemClick: (TechPojo) -> Unit,
) : RecyclerView.Adapter<TechAdapter.TechViewHolder>() {
    class TechViewHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTechnology)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TechViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_technology, parent, false)

        return TechViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TechViewHolder,
        position: Int,
    ) {
        val technology = technologies[position]
        holder.title.text = technology.title
        holder.itemView.setOnClickListener {
            onItemClick(technology)
        }
    }

    override fun getItemCount(): Int = technologies.size
}
