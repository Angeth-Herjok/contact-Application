package com.example.contactapp.viewModel

import android.provider.ContactsContract.Contacts
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactapp.model.ContactData
import com.example.contactapp.model.Repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel: ViewModel() {
    val contactsRepo= ContactsRepository()
    var contactsRepository = ContactsRepository()
    lateinit var contactLiveData: LiveData<Contacts>

    fun saveContact(contact: ContactData){
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }
    }

    fun getContacts():LiveData<List<ContactData>>{
        return contactsRepo.getAllContacts()
    }

    fun getContactById(contactId: Int) {
        contactLiveData = contactsRepository.getContactById(contactId)
    }
}

