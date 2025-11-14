package com.example.assignment3.ui.flowerdetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.assignment3.data.repository.FlowerDataRepository
import com.example.assignment3.domain.Flower
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlowerDetailsViewModel @Inject constructor(
    private val repository: FlowerDataRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val flowerId: String = checkNotNull(savedStateHandle.get<String>("flowerId"))
    private val _uiState: MutableState<FlowerDetailsUiState> = mutableStateOf(FlowerDetailsUiState.Loading)
    val uiState: State<FlowerDetailsUiState> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            delay(2000)

            _uiState.value =
                try {
                    val flower: Flower? = repository.getFlowerById(flowerId)
                    if (flower != null) {
                        FlowerDetailsUiState.Success(flower = flower)
                    } else {
                        FlowerDetailsUiState.Error
                    }
                } catch (_: Exception) {
                    FlowerDetailsUiState.Error
                }
        }
    }

    fun reloadData(){
        _uiState.value = FlowerDetailsUiState.Loading
        loadData()
    }
}