package com.example.assignment3.ui.flowerdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.assignment3.R
import com.example.assignment3.ui.common.ErrorScreenContent
import com.example.assignment3.ui.common.FlowerDataTopAppBar
import com.example.assignment3.ui.common.LoadingScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowerDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: FlowerDetailsViewModel = hiltViewModel(),
    onNavigateBack: (() -> Unit)? = null
) {
    val state: State<FlowerDetailsUiState> = viewModel.uiState
    val uiState: FlowerDetailsUiState = state.value

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            FlowerDataTopAppBar(
                title = stringResource(R.string.list_title),
                scrollBehavior = scrollBehavior,
                onReloadButtonClick = viewModel::reloadData,
                onNavigateBack = onNavigateBack
            )
        }
    ) { innerPadding ->

        when (uiState) {
            is FlowerDetailsUiState.Loading -> {
                LoadingScreenContent(
                    modifier = modifier.padding(innerPadding)
                )
            }

            is FlowerDetailsUiState.Error -> {
                ErrorScreenContent(
                    onRetry = viewModel::reloadData,
                    modifier = modifier.padding(innerPadding)
                )
            }

            is FlowerDetailsUiState.Success ->
                DetailsScreenContent(
                    flower = uiState.flower,
                    modifier = modifier.padding(innerPadding)
                )
        }
    }
}