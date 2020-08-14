package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeButton = findViewById<ImageButton>(R.id.ibHome)
        val favouritesButton = findViewById<ImageButton>(R.id.ibFavourites)
        val contactsButton = findViewById<ImageButton>(R.id.ibContacts)

        val homeFragment = HomeFragment()
        val favouriteFragment = FavouriteFragment()
        val contactsFragment = ContactsFragment()

        fun resetColor(){
            //RESET ALL BUTTONS COLOR TO GREEN
            DrawableCompat.setTint(homeButton.drawable, ContextCompat.getColor(this, R.color.green))
            DrawableCompat.setTint(favouritesButton.drawable, ContextCompat.getColor(this, R.color.green))
            DrawableCompat.setTint(contactsButton.drawable, ContextCompat.getColor(this, R.color.green))
        }


        //WHEN ACTIVITY STARTS
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, homeFragment)
            commit()
            addToBackStack(null)
            resetColor()
            DrawableCompat.setTint(homeButton.drawable, ContextCompat.getColor(this@MainActivity, R.color.red))
        }

        //WHEN HOME IS NAVIGATED TO
        homeButton.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, homeFragment)
                commit()
                addToBackStack(null)
                resetColor()
                DrawableCompat.setTint(homeButton.drawable, ContextCompat.getColor(this@MainActivity, R.color.red))
            }
        }

        //WHEN FAVOURITES IS NAVIGATED TO
        favouritesButton.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, favouriteFragment)
                commit()
                addToBackStack(null)
                resetColor()
                DrawableCompat.setTint(favouritesButton.drawable, ContextCompat.getColor(this@MainActivity, R.color.red))
            }
        }

        //WHEN CONTACTS IS NAVIGATED TO
        contactsButton.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, contactsFragment )
                commit()
                addToBackStack(null)
                resetColor()
                DrawableCompat.setTint(contactsButton.drawable, ContextCompat.getColor(this@MainActivity, R.color.red))
            }
        }
    }
}