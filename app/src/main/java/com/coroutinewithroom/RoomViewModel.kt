package com.coroutinewithroom

import base.BaseViewModel
import mock.MockApi

class RoomViewModel(
    private val api: MockApi,
    private val database: AndroidVersionDatabase
): BaseViewModel<UiState>() {

    fun loadData(){

    }

    fun clearDatabase(){

    }


}








