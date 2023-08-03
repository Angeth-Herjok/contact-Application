package com.example.contactapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Contacts")
data class ContactData(
    @PrimaryKey(autoGenerate = true)
    var contactId: Int,
    var displayName: String,
    var phoneNumber:String,
    var email:String,
    var image:String

)
