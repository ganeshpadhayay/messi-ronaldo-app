package com.example.ganesh.messi_ronaldo.fragment.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.ganesh.messi_ronaldo.R
import com.example.ganesh.messi_ronaldo.domain.model.Games
import com.example.ganesh.messi_ronaldo.ui.component.ErrorButton
import com.example.ganesh.messi_ronaldo.ui.component.LoadingCircular
import com.example.ganesh.messi_ronaldo.ui.component.ProductCard
import com.example.ganesh.messi_ronaldo.ui.theme.MessiRonaldoTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    gamesList: LazyPagingItems<Games>? = null,
    onClickToDetailScreen: (Int) -> Unit = {},
) {
    if (gamesList == null) return
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 100.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(gamesList.itemCount) { index ->
            gamesList[index].let { games ->
                val id = games?.id
                val name = games?.name ?: ""
                val imageUrl = games?.backgroundImage ?: ""
                val releaseDate = games?.released ?: ""
                ProductCard(
                    modifier = modifier
                        .padding(8.dp),
                    name = name,
                    imageUrl = imageUrl,
                    releaseDate = releaseDate,
                    onClickProduct = {
                        id?.let {
                            onClickToDetailScreen.invoke(it)
                        }
                    }
                )
            }
        }
        gamesList.apply {
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                when {
                    loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                        LoadingCircular(
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                    loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {
                        ErrorButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.error_message),
                            onClick = {
                                retry()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MessiRonaldoTheme {
        HomeScreen()
    }
}