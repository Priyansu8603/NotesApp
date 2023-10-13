package com.example.notesapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.notesapp.R

class homepage : AppCompatActivity() {

    lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        navController =findNavController(R.id.fragmentContainerView)
        setupActionBarWithNavController(navController)

    }

    override fun onNavigateUp():Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }
}