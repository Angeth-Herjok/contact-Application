package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        displayContact()


    }
    fun displayContact(){
        val name1=ContactData("Angeth","076564310","angethbecky@gmail.com", "https://images.unsplash.com/photo-1621905252472-943afaa20e20?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        val name2=ContactData("John", "0788564370","johnmwangi@gmail.com","https://images.unsplash.com/photo-1508002366005-75a695ee2d17?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        val name3=ContactData("Wani","0702364550","waniigga@gmail.com","https://images.unsplash.com/photo-1527203561188-dae1bc1a417f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        val name4=ContactData("Herjok","0715364750","herjokmach@gmail.com","https://images.unsplash.com/photo-1518882570151-157128e78fa1?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTh8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        val name5=ContactData("Joy","0795365380","joymoses@gmail.com","https://images.unsplash.com/photo-1522941471521-6ee21ec5cc26?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fGJsYWNrJTIwcGVyc29ufGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60")
        val contactApp= listOf(name1,name2,name3,name4,name5)
        val contactAdapter=ContactAdapter(contactApp)
        binding.rvName.layoutManager=LinearLayoutManager(this)
        binding.rvName.adapter=contactAdapter
    }
}