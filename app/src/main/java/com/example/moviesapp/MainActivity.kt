package com.example.moviesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btn.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            val userName = binding.edUser.text
            val password= binding.edPass.text
            intent.putExtra("USERNAME_KEY","$userName")
            if (userName != null && password!= null && password.length>7){
                Toast.makeText(this,"Login successfully", Toast.LENGTH_LONG).show()

                startActivity(intent)
                finish()
            }
            else if (userName.isEmpty() && password.isEmpty()) Toast.makeText(this , "Please enter username & password",Toast.LENGTH_LONG).show()
            else if (password.length<8)  Toast.makeText(this , "enter password   at least 8 characters",Toast.LENGTH_LONG).show()
            else Toast.makeText(this,"Log in failed",Toast.LENGTH_LONG).show()
        }
    }
}