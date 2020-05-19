package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_include.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        if (Calendar.getInstance().time.hours >=7 && Calendar.getInstance().time.hours<=17){
            lay.setBackgroundResource(R.drawable.pm5sky)
        }else if(Calendar.getInstance().time.hours>=19 || Calendar.getInstance().time.hours<5){
            lay.setBackgroundResource(R.drawable.nightsky)
//            tv1.setTextColor(android.R.color.black)
        }
        else if (Calendar.getInstance().time.hours>=5 && Calendar.getInstance().time.hours<7){
            lay.setBackgroundResource(R.drawable.sunrise)
        }
        else if (Calendar.getInstance().time.hours>=17 && Calendar.getInstance().time.hours<18){
            lay.setBackgroundResource(R.drawable.pm5sky)
        }
        else if (Calendar.getInstance().time.hours>=18 && Calendar.getInstance().time.hours<19){
            lay.setBackgroundResource(R.drawable.sunset)
        }
        else if (Calendar.getInstance().time.hours>=5 && Calendar.getInstance().time.hours<=6){
            lay.setBackgroundResource(R.drawable.sunset)
        }

        GlobalScope.launch (Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) {Client.api.getCurrentWeather("Delhi")}
            if (response.isSuccessful){
                response.body()?.let {res ->
                    res.weather?.let {
                        runOnUiThread {
                            temprature.text = res.main?.temp.toString()
                            maxTemp.text = res.main?.temp_max.toString()
                            minTemp.text = res.main?.temp_min.toString()
                            pressure.text = res.main?.pressure.toString()
                            humidity.text = res.main?.humidity.toString()
                            feelsLike.text = res.main?.feels_like.toString()
                        }
                    }
                }
            }
        }

        btnSearch.setOnClickListener{
            responseWeather()
        }

        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.open,
            R.string.close
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    private fun responseWeather() {
        GlobalScope.launch {
            val response = withContext(Dispatchers.IO) {Client.api.getCurrentWeather(et1.text.toString())}
            if (response.isSuccessful){
                response.body()?.let {res ->
                    res.weather?.let {
                        runOnUiThread {
                            temprature.text = res.main?.temp.toString()
                            maxTemp.text = res.main?.temp_max.toString()
                            minTemp.text = res.main?.temp_min.toString()
                            pressure.text = res.main?.pressure.toString()
                            humidity.text = res.main?.humidity.toString()
                            feelsLike.text = res.main?.feels_like.toString()
                        }
                    }

                }
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.dailyWeather -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
            R.id.next16Days -> {
                startActivity(Intent(this,Main2Activity::class.java))
//                Toast.makeText(this,"next 16 days",Toast.LENGTH_SHORT).show()
            }
            R.id.next24Hours -> {
                Toast.makeText(this,"Next 24 Hours",Toast.LENGTH_SHORT).show()
            }
        }
        drawer.closeDrawer(GravityCompat.START)   //used to close the navigation drawer when the items inside the drawer are clicked
        return true
    }

}
