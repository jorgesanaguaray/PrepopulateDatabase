package com.jorgesanaguaray.prepopulatedatabase.home.presentation

import com.jorgesanaguaray.prepopulatedatabase.core.item.User

/**
 * Created by Jorge Sanaguaray
 */

data class HomeState(

    val users: List<User> = emptyList(),
    val isContent: Boolean = false,
    val isLoading: Boolean = false

)