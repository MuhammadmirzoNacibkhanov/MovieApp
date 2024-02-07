package com.example.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var film: Any
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adaptermain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = Adaptermain {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
        }
        //hello
        binding.film.adapter = adapter

        val list = listOf<Mymodel>(
            Mymodel(
                R.drawable.movie_venomfilm,

                "Venom Let There be Carnage",


                id = 1
            ),
            Mymodel(R.drawable.movie_venomfilm, "King's man", id = 2),
            Mymodel(R.drawable.movie_venomfilm, "Doctor Strange", id = 3),

            )

        adapter.setList(list)

//        adapter.setClickListener {
//            intent.putExtra("myId", it)
//            startActivity(intent)
//        }
    }

}
