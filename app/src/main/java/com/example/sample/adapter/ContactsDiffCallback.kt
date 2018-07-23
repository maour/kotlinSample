package com.example.sample.adapter

import android.support.v7.util.DiffUtil
import com.example.sample.data.ContactModel

class ContactsDiffCallback : DiffUtil.ItemCallback<ContactModel>() {

    override fun areItemsTheSame(oldItem: ContactModel, newItem: ContactModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ContactModel, newItem: ContactModel): Boolean {
        return oldItem == newItem
    }
}