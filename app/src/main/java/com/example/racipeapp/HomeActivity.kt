package com.example.racipeapp

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.racipeapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var rvAdapter: PopularAdapter
    private lateinit var dataList: ArrayList<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_home)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        setUpRecyclerView()
        binding.search.setOnClickListener{
            //This code is self written
            intent = Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }

        binding.salad.setOnClickListener{
            var myIntent= Intent(this@HomeActivity,CategoryActivity::class.java)
            myIntent.putExtra("TITTLE","Salad")
            myIntent.putExtra("CATEGORY","Salad")
            startActivity(myIntent)
        }
        binding.mainDish.setOnClickListener{
            var myIntent= Intent(this@HomeActivity,CategoryActivity::class.java)
            myIntent.putExtra("TITTLE","Main Dish")
            myIntent.putExtra("CATEGORY","Dish")
            startActivity(myIntent)
        }
        binding.drinks.setOnClickListener{
            var myIntent= Intent(this@HomeActivity,CategoryActivity::class.java)
            myIntent.putExtra("TITTLE","Drinks")
            myIntent.putExtra("CATEGORY","Drinks")
            startActivity(myIntent)
        }
        binding.desserts.setOnClickListener{
            var myIntent= Intent(this@HomeActivity,CategoryActivity::class.java)
            myIntent.putExtra("TITTLE","Desserts")
            myIntent.putExtra("CATEGORY","Desserts")
            startActivity(myIntent)
        }

    }



    private fun setUpRecyclerView(){
        dataList= ArrayList()
        binding.rvPopular.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var db= Room.databaseBuilder(this@HomeActivity,AppDatabase::class.java,"db_name")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("recipe.db")
            .build()
        var daoObject=db.getDao()
        var recipes= daoObject.getAll()
        for(i in recipes!!.indices) {
            if (recipes[i]!!.category.contains("Popular")) {
                dataList.add(recipes[i]!!)
            }

            rvAdapter = PopularAdapter(dataList, this)
            binding.rvPopular.adapter = rvAdapter
        }
    }
}