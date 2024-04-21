package com.example.affinity_hw3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.affinity_hw3.databinding.ActivityFlowRegistrationNameBinding


class FlowRegistrationName : AppCompatActivity() {
    private lateinit var binding: ActivityFlowRegistrationNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFlowRegistrationNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val KEY_NAME = resources.getString(R.string.KEY_NAME)

        binding.btnLeft.setOnClickListener {
            finish()
        }

        binding.btnRight.setOnClickListener {
            val etNameText = binding.etName.text.toString()

            if (etNameText.isBlank()) {
                Toast.makeText(this, "Пожалуйста, введите значение", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, FlowRegistrationLastName::class.java)
                intent.putExtra(KEY_NAME, etNameText)
                startActivity(intent)
            }
        }

        binding.btnHome.setOnClickListener {
            finishAffinity()
        }

    }
}