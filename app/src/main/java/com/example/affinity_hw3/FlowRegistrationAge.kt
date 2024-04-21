package com.example.affinity_hw3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.affinity_hw3.databinding.ActivityFlowRegistrationAgeBinding

class FlowRegistrationAge : AppCompatActivity() {
    private lateinit var binding: ActivityFlowRegistrationAgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFlowRegistrationAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val KEY_NAME = resources.getString(R.string.KEY_NAME)
        val KEY_LAST_NAME = resources.getString(R.string.KEY_LAST_NAME)

        val name = intent.getStringExtra(KEY_NAME)
        val lastName = intent.getStringExtra(KEY_LAST_NAME)
        binding.etName.setText(name)
        binding.etLastName.setText(lastName)

        binding.btnLeft.setOnClickListener {
            finish()
        }

        binding.btnRight.setOnClickListener {
            val etLastNameText = binding.etLastName.text.toString()
            val etNameText = binding.etName.text.toString()
            val etAge = binding.etAge.text.toString()

            if (etAge.isBlank()) {
                Toast.makeText(this, "Пожалуйста, введите значение", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainScreen::class.java)
                intent.putExtra(KEY_NAME, etNameText)
                intent.putExtra(KEY_LAST_NAME, etLastNameText)
                startActivity(intent)
                finishAffinity()
            }
        }

        binding.btnHome.setOnClickListener {
            finishAffinity()
        }
    }


}