package com.example.assignment_1_signup

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment_1_signup.ui.theme.Assignment_1_SignupTheme

class MainActivity : ComponentActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextContact: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize EditTexts and Button
        editTextName = findViewById(R.id.editTextName)
        editTextContact = findViewById(R.id.editTextContact)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextAddress = findViewById(R.id.editTextAddress)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        // Handle Submit button click
        buttonSubmit.setOnClickListener {
            if (validateInputs()) {
                // Show a success Toast message
                Toast.makeText(this, "Sign-Up Successful!",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun validateInputs(): Boolean {
        var isValid = true
        // Validate Name
        if (TextUtils.isEmpty(editTextName.text.toString())) {
            editTextName.error = "Name is required"
            isValid = false
        }
        // Validate Contact
        val contact = editTextContact.text.toString()
        if (TextUtils.isEmpty(contact)) {
            editTextContact.error = "Contact number is required"
            isValid = false
        } else if (contact.length != 10 ||
            !contact.matches("\\d+".toRegex())) {
            editTextContact.error = "Enter a valid 10-digit contact number"
            isValid = false
        }
        // Validate Email
        val email = editTextEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            editTextEmail.error = "Email is required"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.error = "Enter a valid email address"
            isValid = false
        }
        // Validate Password
        if (TextUtils.isEmpty(editTextPassword.text.toString())) {
            editTextPassword.error = "Password is required"
            isValid = false
        }
        // Validate Address
        if (TextUtils.isEmpty(editTextAddress.text.toString())) {
            editTextAddress.error = "Address is required"
            isValid = false
        }
        return isValid
        }
}
            @Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment_1_SignupTheme {
        Greeting("Android")
    }
}