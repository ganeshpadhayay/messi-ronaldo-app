package com.example.ganesh.messi_ronaldo.fragment.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ganesh.messi_ronaldo.R
import com.example.ganesh.messi_ronaldo.fragment.detail.screen.DetailScreen
import com.example.ganesh.messi_ronaldo.ui.component.ErrorButton
import com.example.ganesh.messi_ronaldo.ui.component.LoadingCircular
import com.example.ganesh.messi_ronaldo.ui.theme.MessiRonaldoTheme
import com.example.ganesh.messi_ronaldo.utils.Response
import com.example.ganesh.messi_ronaldo.viewmodel.DetailViewModel

@Composable
fun DetailFragment(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = hiltViewModel(),
    id: Int = -1,
) {
    fun launch() {
        detailViewModel.getDetailGames(id)
    }

    launch()
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when (val gamesResponse = detailViewModel.gamesState.value) {
            is Response.Loading -> {
                LoadingCircular(
                    modifier = Modifier.fillMaxWidth()
                )
            }
            is Response.Success -> {
                DetailScreen(
                    games = gamesResponse.data
                )
            }
            is Response.Failure -> {
                ErrorButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.error_message),
                    onClick = {
                        launch()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailFragmentPreview() {
    MessiRonaldoTheme {
        DetailFragment()
    }
}