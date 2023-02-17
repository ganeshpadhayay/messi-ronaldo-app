package com.example.ganesh.messi_ronaldo.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ganesh.messi_ronaldo.domain.model.Games
import com.example.ganesh.messi_ronaldo.domain.repository.GamesRepository
import com.example.ganesh.messi_ronaldo.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val gamesRepository: GamesRepository,
) : ViewModel() {
    private val _gamesState = mutableStateOf<Response<Games>>(Response.Success(null))
    val gamesState: State<Response<Games>> = _gamesState

    fun getDetailGames(id: Int) {
        viewModelScope.launch {
            gamesRepository.getDetailGames(id).collect { response ->
                _gamesState.value = response
            }
        }
    }
}