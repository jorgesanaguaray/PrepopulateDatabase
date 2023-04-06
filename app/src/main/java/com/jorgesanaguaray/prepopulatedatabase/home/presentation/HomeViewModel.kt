package com.jorgesanaguaray.prepopulatedatabase.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgesanaguaray.prepopulatedatabase.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers() {

        viewModelScope.launch {

            _homeState.update {
                it.copy(isContent = false, isLoading = true)
            }

            homeRepository.getUsers().onSuccess { users ->

                _homeState.update {
                    it.copy(users = users, isContent = true, isLoading = false)
                }

            }.onFailure {}

        }

    }

}