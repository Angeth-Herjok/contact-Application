package com.example.contactapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactapp.R
import com.example.contactapp.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    var contactId = 0
    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var bundle=intent.extras
        if(bundle!=null){
            contactId=bundle.getInt("CONTACT_ID",0)
            Toast.makeText(this,"$contactId", Toast.LENGTH_SHORT).show()
        }
    }
}