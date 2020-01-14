package com.prinster.firebaseintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_logged_in.*

class LoggedIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        val auth = FirebaseAuth.getInstance()
        logout.setOnClickListener {
            auth.signOut()
            finish()
        }

    }
}
