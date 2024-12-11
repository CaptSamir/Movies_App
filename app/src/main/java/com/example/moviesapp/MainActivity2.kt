package com.example.moviesapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.ActivityMain2Binding
import com.example.moviesapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Movie>
    lateinit var imageId:Array<Int>
    lateinit var tittleId:Array<String>
    lateinit var discrpId:Array<String>
    lateinit var rateId:Array<String>
    private  fun getmovies(){
        for (i in imageId.indices){
            val movie= Movie(imageId[i],tittleId[i],discrpId[i],rateId[i])
            newArrayList.add(movie)
        }
        newRecyclerView.adapter= MyAdapter(newArrayList)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        val userName= intent.getStringExtra("USERNAME_KEY")
        val txt_userName = binding.textView2
        txt_userName.text = "Welcome,${userName.toString()}"
        imageId= arrayOf(
           // R.drawable.i11,
            //R.drawable.i12,
            //R.drawable.i13,
            //R.drawable.i14,
           // R.drawable.i15,
          R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,R.drawable.i7,R.drawable.i8,R.drawable.i9,R.drawable.i10,

            )
        tittleId = arrayOf(
        //  "  Avengers: Endgame",
         //  " Spider-Man: No Way Home",
          //  "Black Panther",
           // "Guardians of the Galaxy",
           // "Iron Man",
            "Dune: Part Two",
            "All We Imagine as Light",
            "Perfect Days",
            "I Saw the TV Glow",
            "Love Lies Bleeding",
            "Girls Will Be Girls",
            "LaRoy, Texas",
            "Becoming a Guinea Fowl",
            "The Promised Land",
            "I Think About Dying"

        )
       discrpId = arrayOf(
           //"to After the devastating events of Infinity War, the Avengers assemble one last time to reverse the damage and restore balance to the universe.",
             // "to Peter Parker teams up with other versions of Spider-Man from alternate universes to fix a multiverse-altering mistake.",
         // "T Challa, the newly crowned king of Wakanda, faces internal and external threats while embracing his role as the Black Panther.",
           //"A group of misfits led by Peter Quill teams up to save the galaxy from the villainous Ronan the Accuser.",
           //"Billionaire Tony Stark creates a suit of armor to save his life and becomes the armored superhero Iron Man.",
            "A continuation of Paul Atreides' journey on Arrakis as he rises to power and faces enemies while embracing his destiny.",
            "An exploration of working-class life in Mumbai, showcasing its textures and light through poignant storytelling.",
            "A meditative tale of a Tokyo toilet cleaner whose everyday choices reveal a profound inner life.",
            "A psychological horror set in the late 90s about two outcasts bonding over a TV show that transforms their realities.",
            "A queer crime thriller combining family drama, supernatural elements, and pulpy twists in a 1980s Albuquerque setting.",
            "A coming-of-age story about rebellion and desire in a strict Himalayan boarding school.",
            "A mistaken-identity crime story where a broke man is assumed to be a hitman.",
            "A surreal tale exploring identity and transformation in unique and symbolic ways.",
            "A historical drama about resilience and ambition in Denmark's unforgiving landscapes.",
            "A moving story of a terminally ill father seeking a perfect home for his young son."


        )

       rateId = arrayOf(
           //" 8.4",
           //"8.3",
          // "7.3",
          // "8.0",
          //  "7.9,",
                "8.4", // Dune: Part Two
               " 9.0", // All We Imagine as Light
               "8.7", // Perfect Days
               "  8.5", // I Saw the TV Glow
                " 8.3", // Love Lies Bleeding
                 "8.2", // Girls Will Be Girls
                " 8.1", // LaRoy, Texas
                 "8.0", // On Becoming a Guinea Fowl
                "  8.6", // The Promised Land
                " 8.4" , // Sometimes I Think About Dying

        )
        newRecyclerView=binding.rv1
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newArrayList= arrayListOf<Movie>()
        getmovies()












    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)

        }

    }
