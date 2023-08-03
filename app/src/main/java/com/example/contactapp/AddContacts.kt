package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.contactapp.databinding.ActivityAddcontactsBinding
import com.example.contactapp.model.ContactData
import com.example.contactapp.viewModel.ContactsViewModel

class AddContacts : AppCompatActivity() {
    lateinit var binding: ActivityAddcontactsBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcontacts)
        binding= ActivityAddcontactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            validateAddContact()
        }
    }

    fun validateAddContact() {
        val firstName = binding.etName.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val emailAddress = binding.etEmail.text.toString()

        var error = false

        if (firstName.isBlank()) {
            binding.tilName.error = "name required"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "phone number required"
            error = true
        }
        if (emailAddress.isBlank()) {
            binding.tilEmail.error = "email address required"
            error = true
        }
        if (!error) {
            val newContact = ContactData(0, firstName, phoneNumber, emailAddress, "")
            contactsViewModel.saveContact(newContact)
            Toast.makeText(this,getString(R.string.contact_save), Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}







