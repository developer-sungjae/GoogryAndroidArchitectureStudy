package com.example.architecture.activity.search.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.R
import com.example.architecture.data.model.MovieModel

class MovieAdapter : RecyclerView.Adapter<MovieHolder>(), MovieAdapterContract.View {

    private val movieList = mutableListOf<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        val viewHolder = MovieHolder(view)

        view.setOnClickListener {
            openWebPage(it.context, movieList[viewHolder.layoutPosition].link)
        }

        return viewHolder
    }

    private fun openWebPage(context: Context, link: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        val movie = movieList[position]
        holder.onBind(movie)
    }

    fun addNewItems(movieList: List<MovieModel>) {
        if (this.movieList.isNotEmpty()) {
            this.movieList.clear()
        }

        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }
}


