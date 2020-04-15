package com.olaf.nukeolaf.data.local

import android.content.Context
import com.google.gson.GsonBuilder
import com.olaf.nukeolaf.R
import com.olaf.nukeolaf.data.model.MovieResponse

class MovieLocalDataSourceImpl(context: Context) : MovieLocalDataSource {

    private val name = context.resources.getString(R.string.MOVIE_CACHE_DATA)
    private val sharedPreferences =
        context.getSharedPreferences(name, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    override fun saveMovies(movies: MovieResponse) {
        editor.putString(name, GsonBuilder().create().toJson(movies))
        editor.commit()
    }

    override fun getMovies(): MovieResponse? {
        val movies = sharedPreferences.getString(name, null)
        return if (movies != null) {
            GsonBuilder().create().fromJson(movies, MovieResponse::class.java)
        } else {
            null
        }
    }
}