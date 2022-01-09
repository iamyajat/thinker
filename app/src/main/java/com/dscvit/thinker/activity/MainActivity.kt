package com.dscvit.thinker.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dscvit.thinker.R
import com.dscvit.thinker.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigationView
        navView.menu.findItem(R.id.dummy).isEnabled = false

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment

        navView.setupWithNavController(navHostFragment.navController)

        binding.createDeckButton.setOnClickListener {
            val createDeckIntent = Intent(this, SearchDeckActivity::class.java)
            startActivity(createDeckIntent)
        }
    }

}
