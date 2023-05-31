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
        val name1=ContactData("Angeth","076564310","angethbecky@gmail.com")
        val name2=ContactData("John", "0788564370","johnmwangi@gmail.com")
        val name3=ContactData("Wani","0702364550","waniigga@gmail.com")
        val name4=ContactData("Herjok","0715364750","herjokmach@gmail.com")
        val name5=ContactData("Joy","0795365380","joymoses@gmail.com")
        val contactApp= listOf(name1,name2,name3,name4,name5)
        val contactAdapter=ContactAdapter(contactApp)
        binding.rvName.layoutManager=LinearLayoutManager(this)
        binding.rvName.adapter=contactAdapter
    }
}