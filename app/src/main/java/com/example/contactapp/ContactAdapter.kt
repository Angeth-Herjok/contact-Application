package com.example.contactapp


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.contactapp.databinding.ContactListItemBinding
import com.example.contactapp.model.ContactData
import com.example.contactapp.ui.ContactDetailsActivity
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactAdapter(var ContactList:List<ContactData>, var context: Context) : RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ContactListItemBinding .inflate(LayoutInflater.from(parent.context),parent ,false)
        return ContactViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return ContactList.size
    }
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact =ContactList.get(position)
        var  binding=holder.binding
        binding.ivAvatar.tag=currentContact.image
        binding.tvDisplayName.text=currentContact.displayName
        binding.tvNumber.text=currentContact.phoneNumber
        binding.tvEmail.text =currentContact.email


        if (currentContact.image.isNotEmpty()) {
            Picasso
                .get()
                .load(currentContact.image)
                .transform(CropCircleTransformation())
                .into(binding.ivAvatar)
        }
        binding.cvContact.setOnClickListener{
            val intent=Intent(context, ContactDetailsActivity::class.java)
            intent.putExtra("CONTACT_ID",currentContact.contactId)
            context.startActivity(intent)
        }

    }

}
class ContactViewHolder( var binding:ContactListItemBinding):ViewHolder(binding.root)