package com.example.assignment3.ui.flowerlist

import com.example.assignment3.domain.Flower

sealed interface FlowerListUiState {
    object Loading: FlowerListUiState
    data class Success(val flowers: List<Flower>): FlowerListUiState
    object Error: FlowerListUiState
}