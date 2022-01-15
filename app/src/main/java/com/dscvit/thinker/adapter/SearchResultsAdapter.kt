package com.dscvit.thinker.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dscvit.thinker.R
import com.dscvit.thinker.model.Search


class SearchResultsAdapter(
    private var searchResults: List<Search>,
) : RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val resultTextView: TextView = view.findViewById(R.id.search_result_text_view)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_search_result, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val searchResult = searchResults[position]
        viewHolder.resultTextView.text = searchResult.index.toString() + " - " + searchResult.title
        viewHolder.itemView.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://en.wikipedia.org/wiki/" + searchResult.title.replace(" ", "_"))
            )
            viewHolder.itemView.context.startActivity(browserIntent)
        }
    }

    fun dataSetChange(newSearchResults: List<Search>) {
        searchResults = newSearchResults
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = searchResults.size
}