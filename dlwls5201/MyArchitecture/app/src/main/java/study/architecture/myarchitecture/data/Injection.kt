package study.architecture.myarchitecture.data

import android.content.Context
import study.architecture.myarchitecture.data.repository.UpbitRepository
import study.architecture.myarchitecture.data.repository.UpbitRepositoryImpl
import study.architecture.myarchitecture.data.source.local.LocalDataBase
import study.architecture.myarchitecture.data.source.remote.RemoteClient
import study.architecture.myarchitecture.util.NetworkUtil

object Injection {

    fun provideFolderRepository(context: Context): UpbitRepository {
        val localDataSource = LocalDataBase.getInstance(context)
        return UpbitRepositoryImpl(
            RemoteClient.provideUpbitApi(),
            localDataSource.getUpbitDao(),
            NetworkUtil.isOnline(context)
        )

    }
}