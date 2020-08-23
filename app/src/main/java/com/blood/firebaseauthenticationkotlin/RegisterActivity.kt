package com.blood.firebaseauthenticationkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_button.setOnClickListener()
        {
            var email_text: String=email_text.text.toString()
            var password_text: String=password_text.text.toString()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email_text, password_text)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                       // Log.d(TAG, "createUserWithEmail:success")
                        //val user = auth.currentUser
                        //updateUI(user)
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                       // Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        //updateUI(null)
                    }

                    // ...
                }

        }

    }
}
