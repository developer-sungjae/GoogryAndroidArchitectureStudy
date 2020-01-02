package com.example.studyapplication.ui.main.blog

import android.util.Log
import com.example.studyapplication.data.model.SearchBlogResult
import com.example.studyapplication.data.repository.NaverSearchRepository
import com.example.studyapplication.network.Conn
import com.example.studyapplication.ui.main.base.BaseSearchPresenter

class BlogPresenter(
    override val view: BlogContract.View,
    private val repository: NaverSearchRepository
) : BaseSearchPresenter(view), BlogContract.Presenter {

    override fun clickSearchButton(query: String) {
        Log.e("test", ">>> clickSearchButton")


        repository.getBlogList(query, object : Conn {
            override fun <T> success(result: T) {
                val searchData: SearchBlogResult? = result as SearchBlogResult
                searchData?.let {
                    view.showList(searchData.arrBlogInfo)
                }
            }

            override fun failed(e: Throwable) {
                Log.e("test", ">>> failed() ")
                onRequestFailed(e)
            }
        })
    }
}