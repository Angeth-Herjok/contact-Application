package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.ActivityMainBinding
import com.example.contactapp.model.ContactData
import com.example.contactapp.viewModel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabNew
            .setOnClickListener {
                val intent = Intent(this,AddContacts::class.java)
                startActivity(intent)
            }
    }
    override fun onResume() {
        super.onResume()
        contactsViewModel.getContacts().observe(this, Observer { contactList-> displayContact(contactList) })
        binding.fabNew.setOnClickListener {
            startActivity(Intent(this, AddContacts::class.java))}



    }
    fun displayContact(contactList: List<ContactData>){
//        val name1= ContactData(0,"Angeth","0767542390","angethherjok@gmail.com","https://images.unsplash.com/photo-1621905252472-943afaa20e20?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
//        val name2= ContactData(0,"Becky","0757542398","beckyherjok@gmail.com","https://images.unsplash.com/photo-1508002366005-75a695ee2d17?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
//        val name3= ContactData(0,"John","0790542393","johnherjok@gmail.com","https://images.unsplash.com/photo-1621905252472-943afaa20e20?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
//        val name4= ContactData(0,"Herjok","0777542399","herjok@gmail.com","https://images.unsplash.com/photo-1621905252472-943afaa20e20?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
//        val name5= ContactData(0,"Joy","0789542393","joy@gmail.com","https://images.unsplash.com/photo-1621905252472-943afaa20e20?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")

//        val contactApp= listOf(name1,name2,name3,name4,name5)
        val contactAdapter=ContactAdapter(contactList,this)
        binding.rvName.layoutManager=LinearLayoutManager(this)
        binding.rvName.adapter=contactAdapter
    }
}