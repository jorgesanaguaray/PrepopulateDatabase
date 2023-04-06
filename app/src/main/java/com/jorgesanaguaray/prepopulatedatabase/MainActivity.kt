package com.jorgesanaguaray.prepopulatedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jorgesanaguaray.prepopulatedatabase.home.presentation.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mContainer, HomeFragment.newInstance())
                .commitNow()

        }

    }

}