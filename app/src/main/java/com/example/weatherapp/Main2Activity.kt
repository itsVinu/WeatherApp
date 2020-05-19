package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.days16response.DataItem
import com.example.weatherapp.days16response.Next16DaysResponse
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_include.*
import kotlinx.android.synthetic.main.main_include2.*
import kotlinx.android.synthetic.main.main_include2.toolbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Main2Activity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    val list = arrayListOf<DataItem>()
    val next16adapter = Next16Adapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setSupportActionBar(toolbar)


        next16Rv.apply {
            layoutManager = GridLayoutManager(this@Main2Activity,2,RecyclerView.VERTICAL,false)
            adapter = next16adapter
        }


        GlobalScope.launch {
            val response = withContext(Dispatchers.IO) {Client.api1.get16daysweather("delhi")}
            if (response.isSuccessful) {
                response.body()?.let { res->
                    res.data?.let { list.addAll(it)}
                        runOnUiThread { next16adapter.notifyDataSetChanged() }
                    }
                }
            }


        btnSearch1.setOnClickListener{
            next16response()
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

    private fun next16response() {
        GlobalScope.launch {
            val response = withContext(Dispatchers.IO) {Client.api1.get16daysweather(et2.text.toString())}
            if (response.isSuccessful) {
                response.body()?.let { res->
                    res.data?.let { list.clear()
                        list.addAll(it)}
                    runOnUiThread { next16adapter.notifyDataSetChanged() }
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
//                Toast.makeText(this,"next 16 days", Toast.LENGTH_SHORT).show()
            }
            R.id.next24Hours -> {
                Toast.makeText(this,"Next 24 Hours", Toast.LENGTH_SHORT).show()
            }
        }
        drawer.closeDrawer(GravityCompat.START)   //used to close the navigation drawer when the items inside the drawer are clicked
        return true
    }
}
