package com.raihan.abcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.raihan.abcalculation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawlerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var navController = findNavController(R.id.fragmentContainerView)
        binding.bottombar.setupWithNavController(navController)

        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.nav_open,R.string.nav_close)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return if (actionBarDrawerToggle.onOptionsItemSelected(item)){
           true
       }else super.onOptionsItemSelected(item)
    }
}