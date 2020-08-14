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

        val homebutton = findViewById<ImageButton>(R.id.ibHome)
        val favouritesbutton = findViewById<ImageButton>(R.id.ibFavourites)
        val contactsbutton = findViewById<ImageButton>(R.id.ibContacts)

        val homeFragment = HomeFragment()
        val favouriteFragment = FavouriteFragment()
        val contactsFragment = ContactsFragment()

        fun resetColor(){
            //RESET ALL BUTTONS COLOR TO GREEN
            DrawableCompat.setTint(homebutton.drawable, ContextCompat.getColor(this, R.color.green))
            DrawableCompat.setTint(favouritesbutton.drawable, ContextCompat.getColor(this, R.color.green))
            DrawableCompat.setTint(contactsbutton.drawable, ContextCompat.getColor(this, R.color.green))
        }


        //WHEN ACTIVITY STARTS
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, homeFragment)
            commit()
            addToBackStack(null)
            resetColor()
            DrawableCompat.setTint(homebutton.drawable, ContextCompat.getColor(this@MainActivity, R.color.red))
        }

        //WHEN HOME IS NAVIGATED TO
        homebutton.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, homeFragment)
                commit()
                addToBackStack(null)
                resetColor()
                DrawableCompat.setTint(homebutton.drawable, ContextCompat.getColor(this@MainActivity, R.color.red))
            }
        }

        //WHEN FAVOURITES IS NAVIGATED TO
        favouritesbutton.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, favouriteFragment)
                commit()
                addToBackStack(null)
                resetColor()
                DrawableCompat.setTint(favouritesbutton.drawable, ContextCompat.getColor(this@MainActivity, R.color.red))
            }
        }

        //WHEN CONTACTS IS NAVIGATED TO
        contactsbutton.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, contactsFragment )
                commit()
                addToBackStack(null)
                resetColor()
                DrawableCompat.setTint(contactsbutton.drawable, ContextCompat.getColor(this@MainActivity, R.color.red))
            }
        }
    }
}