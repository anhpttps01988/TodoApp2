package anh.ptt.todoapp.config

import anh.ptt.data.datasource.remote.rest.BuildConfig
import javax.inject.Inject


class BuildConfigImp @Inject constructor(): BuildConfig {
    override fun getBaseUrl(): String {
        return "https://my-json-server.typicode.com/imkhan334/demo-1/"
    }
}