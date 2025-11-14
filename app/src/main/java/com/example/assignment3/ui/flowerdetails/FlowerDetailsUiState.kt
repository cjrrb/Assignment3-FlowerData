package com.example.assignment3.ui.flowerdetails

import com.example.assignment3.domain.Flower

sealed interface FlowerDetailsUiState {
    object Loading : FlowerDetailsUiState
    data class Success(val flower: Flower) : FlowerDetailsUiState
    object Error : FlowerDetailsUiState
}