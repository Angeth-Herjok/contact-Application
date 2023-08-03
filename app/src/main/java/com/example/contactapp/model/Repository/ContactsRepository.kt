package com.example.contactapp.model.Repository

import android.provider.ContactsContract.Contacts
import androidx.lifecycle.LiveData
import com.example.contactapp.MyContactsApp
import com.example.contactapp.database.ContactsDb
import com.example.contactapp.model.ContactData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDb.getDatabase(MyContactsApp.appContext)

    suspend fun saveContact(contact:ContactData){
        withContext(Dispatchers.IO){
            database.getContactDao().insertContact(contact)
        }
    }

    fun getAllContacts():LiveData<List<ContactData>>{
        return database.getContactDao().getAllContacts()
    }
}