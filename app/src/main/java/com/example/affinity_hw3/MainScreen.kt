package com.example.affinity_hw3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.affinity_hw3.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {

    private lateinit var binding : ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val KEY_NAME = resources.getString(R.string.KEY_NAME)
        val KEY_LAST_NAME = resources.getString(R.string.KEY_LAST_NAME)

        val firstName = intent.getStringExtra(KEY_NAME)
        val lastName = intent.getStringExtra(KEY_LAST_NAME)

        Toast.makeText(this, "Добро пожаловать, $firstName $lastName", Toast.LENGTH_SHORT).show()

        binding.btnHome.setOnClickListener {
            finish()
        }
    }
}