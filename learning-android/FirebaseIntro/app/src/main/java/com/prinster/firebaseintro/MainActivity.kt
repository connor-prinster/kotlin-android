package com.prinster.firebaseintro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        // Authentication
        mAuth = FirebaseAuth.getInstance()

        create_button.setOnClickListener{loginButtonClicked()}
        login_existing.setOnClickListener { signInButtonClicked() }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
        if(currentUser != null) {
            val intent = Intent(this, LoggedIn::class.java)
            startActivity(intent)
        }
    }

    private fun loginButtonClicked() {
        val username = username_input.text.toString()
        val password = password_input.text.toString()

        createAccount(username, password)
    }

    private fun signInButtonClicked() {
        val username = username_input.text.toString()
        val password = password_input.text.toString()

        signIn(username, password)
    }

    private fun createAccount(username:String, password:String) {
        mAuth!!.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful) {
                    Toast.makeText(this, "Created Account Successful!", Toast.LENGTH_SHORT).show()
                    val user = mAuth!!.currentUser
                    val intent = Intent(this, LoggedIn::class.java)
                    startActivity(intent)
                    Log.d("Login:", user!!.displayName.toString())
                }
                else {
                    Toast.makeText(this, "Creation Failure", Toast.LENGTH_SHORT).show()
            }}
    }

    private fun signIn(username:String, password: String) {
        mAuth!!.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener (this){ task ->
                if(task.isSuccessful) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoggedIn::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
