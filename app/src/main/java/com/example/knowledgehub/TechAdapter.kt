package com.example.knowledgehub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TechAdapter(
    private val technologies: List<TechPojo>,
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
        holder.title.text = technologies[position].title
    }

    override fun getItemCount(): Int = technologies.size
}
