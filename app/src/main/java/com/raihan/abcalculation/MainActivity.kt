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
       // binding.drawerNav.setupWithNavController(navController)

        actionBarDrawerToggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.nav_open,R.string.nav_close)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.drawerNav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.BMIFragment ->{
                    binding.drawerNav.setupWithNavController(navController)
                    binding.drawerLayout.closeDrawers()
                }
                R.id.scientificFragment -> {
                    binding.drawerNav.setupWithNavController(navController)
                    binding.drawerLayout.closeDrawers()
                }
                R.id.tempFragment ->{
                    binding.drawerNav.setupWithNavController(navController)
                    binding.drawerLayout.closeDrawers()
                }
                R.id.white ->{
                    binding.drawerLayout.setBackgroundColor(getResources().getColor(R.color.white))
                    binding.bottombar.setBackgroundColor(getResources().getColor(R.color.white))
                    binding.drawerLayout.closeDrawers()

                }
                R.id.black ->{
                    binding.drawerLayout.setBackgroundColor(getResources().getColor(R.color.black))
                    binding.bottombar.setBackgroundColor(getResources().getColor(R.color.black))
                    binding.drawerLayout.closeDrawers()

                }
                R.id.red ->{
                    binding.drawerLayout.setBackgroundColor(getResources().getColor(R.color.red))
                    binding.bottombar.setBackgroundColor(getResources().getColor(R.color.red))
                    binding.drawerLayout.closeDrawers()

                }
            }
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return if (actionBarDrawerToggle.onOptionsItemSelected(item)){
           true
       }else super.onOptionsItemSelected(item)
    }
}