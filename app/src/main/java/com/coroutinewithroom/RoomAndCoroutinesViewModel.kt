package com.coroutinewithroom

import androidx.lifecycle.viewModelScope
import com.coroutinewithroom.base.BaseViewModel
import com.coroutinewithroom.AndroidVersionDao
import kotlinx.coroutines.launch
import com.coroutinewithroom.mock.MockApi

class RoomAndCoroutinesViewModel(
    private val api: MockApi,
    private val database: AndroidVersionDao
) : BaseViewModel<UiState>() {

    fun loadData() {
        uiState.value = UiState.Loading.LoadFromDb

        viewModelScope.launch {
            //First we load android version from Room DB
            val localVersions = database.getAndroidVersions()
            if(localVersions.isEmpty()){
                uiState.value = UiState.Error(DataSource.DATABASE, "Database Empty!")
            } else {
                uiState.value = UiState.Success(DataSource.DATABASE, localVersions.mapToUiModelList())
            }

            //Call Network API
            uiState.value = UiState.Loading.LoadFromNetwork
            try {
                //Fetch data from network
                val recentVersions = api.getRecentAndroidVersions()
                //Insert network data into RoomDB
                for (version in recentVersions) {
                    database.insert(version.mapToEntity())
                }
                uiState.value = UiState.Success(DataSource.NETWORK, recentVersions)
            } catch (exc : Exception){
                uiState.value = UiState.Error(DataSource.NETWORK, "Something went wrong!")
            }

        }

    }

    fun clearDatabase() {
        viewModelScope.launch {
            database.clear()
        }
    }
}

enum class DataSource(val dataSourceName: String) {
    DATABASE("Database"),
    NETWORK("Network")
}