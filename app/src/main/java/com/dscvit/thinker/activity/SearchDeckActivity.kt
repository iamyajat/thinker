package com.dscvit.thinker.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.dscvit.thinker.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchDeckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_deck)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navHostFragment.navController.apply {
            popBackStack()
            navigate(R.id.navigation_search_topic)
        }


    }
}