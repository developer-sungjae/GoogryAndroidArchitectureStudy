package com.example.architecture.data.source.remote

import com.example.architecture.data.model.MovieModel

interface NaverRemoteDataSource {

    fun getMovieList(
        keyWord: String,
        onSuccess: (movieList: List<MovieModel>) -> Unit,
        onFailure: (t: Throwable) -> Unit,
        saveMovieInLocal: (keyword: String, movieList: List<MovieModel>) -> Unit
    )

}