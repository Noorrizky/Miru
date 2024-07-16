package com.example.nontonin

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val welcomeTextView: TextView = findViewById(R.id.textView)
        val logoImageView: ImageView = findViewById(R.id.imageView)
        val loginButton: ImageButton = findViewById(R.id.loginButton)


        loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
}
