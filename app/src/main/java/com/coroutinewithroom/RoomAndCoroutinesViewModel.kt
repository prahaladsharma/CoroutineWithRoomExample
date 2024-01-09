package com.coroutinewithroom

import base.BaseViewModel
import com.coroutinewithroom.AndroidVersionDao
import mock.MockApi

class RoomAndCoroutinesViewModel(
    private val api: MockApi,
    private val database: AndroidVersionDao
) : BaseViewModel<UiState>() {

    fun loadData() {

    }

    fun clearDatabase() {

    }
}

enum class DataSource(val dataSourceName: String) {
    DATABASE("Database"),
    NETWORK("Network")
}