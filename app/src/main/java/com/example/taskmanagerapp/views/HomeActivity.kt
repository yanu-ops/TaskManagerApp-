package com.example.taskmanagerapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanagerapp.R
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var textViewMessage: TextView
    private lateinit var btnSignOut: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        textViewMessage = findViewById(R.id.textView3)
        btnSignOut = findViewById(R.id.button)

        auth = FirebaseAuth.getInstance()

        textViewMessage.text = "Congratulations, you are signed in!"

        btnSignOut.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        auth.signOut()
        Toast.makeText(this, "Successfully signed out", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}
