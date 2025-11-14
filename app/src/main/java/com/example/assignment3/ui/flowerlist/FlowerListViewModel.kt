package com.example.assignment3.ui.flowerlist

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.data.repository.FlowerDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.State
import javax.inject.Inject

@HiltViewModel
class FlowerListViewModel @Inject constructor(
    private val repository: FlowerDataRepository
): ViewModel() {
    private val _uiState: MutableState<FlowerListUiState> =
        mutableStateOf(FlowerListUiState.Loading)

    val uiState: State<FlowerListUiState> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            delay(2000)

            _uiState.value = try {
                FlowerListUiState.Success(repository.getAllFlowers())
            } catch (e: Exception) {
                Log.e("FlowerListViewModel", "loadData: ${e.message}")
                FlowerListUiState.Error
            }
        }
    }

    fun reloadData(){
        _uiState.value = FlowerListUiState.Loading
        loadData()
    }
}