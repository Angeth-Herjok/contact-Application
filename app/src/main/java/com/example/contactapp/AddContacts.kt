package com.example.contactapp

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.FileProvider
import androidx.core.content.PackageManagerCompat
import com.example.contactapp.databinding.ActivityAddcontactsBinding
import com.example.contactapp.model.ContactData
import com.example.contactapp.viewModel.ContactsViewModel
import java.io.File

class AddContacts : AppCompatActivity() {
    lateinit var binding: ActivityAddcontactsBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    lateinit var photoFile: File
    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var location: Location


    private val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
        if (result.resultCode == RESULT_OK){
            val photo = BitmapFactory.decodeFile(photoFile.absolutePath)
            binding.ivNewContact.setImageBitmap(photo)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcontacts)
        binding= ActivityAddcontactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient()
    }

    val locationRequest =registerForActivityResult(ActivityResultContracts.RequestPermission()){ result->
        if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_PERMISSION)== PackageManager.PERMISSION_GRANTED)
            getLastKnownLoaction()
    }
    else{
        Toast
    }


    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            validateAddContact()
        }
        binding.ivNewContact.setOnClickListener {
            capturePhoto()
        }
        getLastKnownLoaction()
    }
        fun getLastKnownLoaction() {
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager)
                fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    mylocation = location
                    Toast.makeText(this, "Lat: ${location.latitude}", Toast.LENGTH_LONG).show()

                }
            else{
                locationRequest.launch(Manifest.permission.ACCESS_COARSE_PERMISSION)
            }

        }





    private fun capturePhoto(){
        val photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = getPhotoFile("photo_${System.currentTimeMillis()}")
        val fileProvider = FileProvider.getUriForFile(this,"com.example.contactapp.provider", photoFile)
        photoIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        cameraLauncher.launch(photoIntent)

    }
    private fun getPhotoFile(fileName:String):File{
        val folder = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var tempFile = File.createTempFile(fileName, ".jpeg",folder)
        return tempFile
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
            val newContact = ContactData(0, firstName, phoneNumber, emailAddress, photoFile.absolutePath)
            contactsViewModel.saveContact(newContact)
            Toast.makeText(this,getString(R.string.contact_save), Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}







