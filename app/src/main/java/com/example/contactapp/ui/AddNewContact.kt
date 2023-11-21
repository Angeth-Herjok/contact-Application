package com.example.contactapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactapp.R
import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import com.example.contactapp.MainActivity
import com.example.contactapp.databinding.ActivityAddNewContactBinding
import com.example.contactapp.model.ContactData
import com.example.contactapp.viewModel.ContactsViewModel

class AddNewContact : AppCompatActivity() {
    lateinit var binding: ActivityAddNewContactBinding
    val contactViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        binding.btnSave.setOnClickListener {
            validateNew()
        }
    }
    fun validateNew() {
        val name = binding.etName.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false

        if (name.isBlank()) {
            binding.tilName.error = getString(R.string.name_is_required)
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = getString(R.string.phonenumber_is_required)
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = getString(R.string.email_is_required)
            error = true
        }
        if (!error) {
            val newContact= ContactData(contactId = 0, displayName = name, phoneNumber = phoneNumber, email = email, image = email )
            contactViewModel.saveContact(newContact)
            Toast.makeText(this,"Contact saved",Toast.LENGTH_LONG).show()
            finish()

        }
    }

}