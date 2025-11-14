package com.example.assignment3.ui.flowerlist

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.assignment3.R
import com.example.assignment3.ui.common.ErrorScreenContent
import com.example.assignment3.ui.common.FlowerDataTopAppBar
import com.example.assignment3.ui.common.LoadingScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowerListScreen(
    modifier: Modifier = Modifier,
    viewModel: FlowerListViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit = {}
){
    val state: State<FlowerListUiState> = viewModel.uiState
    val uiState: FlowerListUiState = state.value

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            FlowerDataTopAppBar(
                title = stringResource(R.string.list_title),
                onReloadButtonClick = viewModel::reloadData,
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        when(uiState){
            is FlowerListUiState.Loading -> LoadingScreenContent()
            is FlowerListUiState.Error -> ErrorScreenContent(
                onRetry = viewModel::reloadData
            )
            is FlowerListUiState.Success -> ListScreenContent(
                flowerList = uiState.flowers,
                onItemClick = onItemClick,
                modifier = modifier.padding(innerPadding)
            )
        }
    }
}