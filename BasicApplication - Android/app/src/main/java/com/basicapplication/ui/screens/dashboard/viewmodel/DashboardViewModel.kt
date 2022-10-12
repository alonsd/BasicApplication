package com.basicapplication.ui.screens.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basicapplication.data.repository.Repository
import com.basicapplication.model.models.BasicApplicationModel
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: Repository) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()


    init {
        getBasicApplicationData()
    }


    private fun getBasicApplicationData() = viewModelScope.launch(Dispatchers.IO) {
        when (val response = repository.getDataFromApi()) {
            is NetworkResponse.Success -> {
                _uiState.update { it.copy(modelsList = response.body.numbers, state = UiState.State.Data) }
            }

            is NetworkResponse.Error -> {
                val message = response.error.message ?: run { return@launch }
                _uiState.update { it.copy(errorMessage = message, state = UiState.State.Error) }
            }
            else -> Unit
        }
    }

    data class UiState(
        val modelsList: List<BasicApplicationModel.Number> = emptyList(),
        val errorMessage: String = "",
        val state: State = State.Initial
    ) {
        enum class State {
            Initial,
            Data,
            Error
        }
    }
}