package com.example.affinity_hw3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.affinity_hw3.databinding.ActivityFlowRegistrationLastNameBinding
import com.example.affinity_hw3.databinding.ActivityMainBinding

class FlowRegistrationLastName : AppCompatActivity() {
    private lateinit var binding: ActivityFlowRegistrationLastNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFlowRegistrationLastNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val KEY_NAME = resources.getString(R.string.KEY_NAME)
        val KEY_LAST_NAME = resources.getString(R.string.KEY_LAST_NAME)

        val name = intent.getStringExtra(KEY_NAME)
        binding.etName.setText(name)

        binding.btnLeft.setOnClickListener {
            finish()
        }

        binding.btnRight.setOnClickListener {
            val etLastNameText = binding.etLastName.text.toString()
            val etNameText = binding.etName.text.toString()

            if (etLastNameText.isBlank()) {
                Toast.makeText(this, "Пожалуйста, введите значение", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, FlowRegistrationAge::class.java)
                intent.putExtra(KEY_NAME, etNameText)
                intent.putExtra(KEY_LAST_NAME, etLastNameText)
                startActivity(intent)
            }
        }

        binding.btnHome.setOnClickListener {
            finishAffinity()
        }
    }
}