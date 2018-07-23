package com.example.sample.adapter

import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sample.R
import com.example.sample.data.ContactModel
import com.example.sample.databinding.ContactRowBinding


class ContactsAdapter(private val itemClickListener: View.OnClickListener)
    : ListAdapter<ContactModel, ContactsAdapter.PersonsViewHolder>(ContactsDiffCallback()) {

    override fun onBindViewHolder(holder: PersonsViewHolder, position: Int) {
        getItem(position).let { person ->
            with(holder) {
                itemView.tag = person
                bind(itemClickListener, person)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonsViewHolder {
        return PersonsViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.context)
                , R.layout.contact_row,
                parent,
                false)
        )
    }


    class PersonsViewHolder(private val binding: ContactRowBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemClickListener: View.OnClickListener, item: ContactModel) {
            with(binding) {
                clickListener = itemClickListener
                person = item
            }
        }
    }

}

