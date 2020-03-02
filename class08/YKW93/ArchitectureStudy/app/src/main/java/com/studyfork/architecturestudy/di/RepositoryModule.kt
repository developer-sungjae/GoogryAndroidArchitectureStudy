package com.studyfork.architecturestudy.di

import com.studyfork.architecturestudy.data.repository.MovieRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MovieRepositoryImpl(get())
    }
}