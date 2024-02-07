package com.example.exameight.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exameight.R
import com.example.exameight.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupBottomNavigationView() {
        // Set the default selected item
        binding.bottomNav.selectedItemId = R.id.home // Assuming R.id.home is the ID of the default home item

        // Apply the selector to the BottomNavigationView
        binding.bottomNav.itemBackgroundResource = R.drawable.bottom_nav_item_selector

        // Handle item selection
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    // Handle home item click
                    true
                }
                R.id.favorites -> {
                    // Handle favorites item click
                    true
                }
                R.id.chats -> {
                    // Handle chats item click
                    true
                }
                // Add more cases for other menu items as needed
                else -> false
            }
        }
    }

}