package com.example.contactapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.contactapp.AddContacts
import com.example.contactapp.R
import com.example.contactapp.databinding.ActivityContactDetailsBinding
import com.example.contactapp.model.ContactData
import com.example.contactapp.viewModel.ContactsViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation



class ContactDetailsActivity : AppCompatActivity() {
    var contactId = 0
    private lateinit var viewModel: ContactsViewModel

    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDelete.setOnClickListener {
        }


        viewModel = ContactsViewModel()
        val contactId = intent.getIntExtra("CONTACT_ID", 0)
        ContactsViewModel.getContactById()(contactId).observe(this, Observer{ contacts ->
            if (contacts != null) {
                displayContactDetails(contacts)
            } else {
                Toast.makeText(this, "Contact not found", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun displayContactDetails(contact: ContactData) {
        binding.tilName.text = contact.displayName
        binding.tilPhoneNumber.text = contact.phoneNumber
        binding.tilEmail.text = contact.email
        if (!contact.image.isNullOrEmpty()) {
            Picasso
                .get()
                .load(contact.image)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.ivImage)
        }
    }
}










