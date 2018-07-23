package com.example.sample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.sample.adapter.ContactsAdapter
import com.example.sample.data.ContactModel
import com.example.sample.viewModel.ContactsListViewModel
import com.example.sample.viewModel.ContactsListViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_contacts_list.*
import kotlinx.android.synthetic.main.contacts_list.*
import javax.inject.Inject

class ContactsListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var contactVMFactory: ContactsListViewModelFactory

    private lateinit var contactsVM: ContactsListViewModel

    private var twoPane: Boolean = false
    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_list)

        setupAdapter()

        createAndObserveViewModel()

        setupView()
    }

    override fun onResume() {
        super.onResume()
        contactsVM.loadContacts()
    }

    private fun setupAdapter() {
        contactsAdapter = ContactsAdapter(
                View.OnClickListener { v ->
                    when {
                        twoPane -> updateFragment(v)
                        else -> showDetailActivity(v)
                    }
                })
    }

    private fun createAndObserveViewModel() {
        contactsVM = ViewModelProviders.of(this, contactVMFactory).get(ContactsListViewModel::class.java)
        contactsVM.personsListResponse()
                .observe(this
                        , Observer { listOfContacts ->
                    contactsAdapter.submitList(listOfContacts)
                })
    }

    private fun showDetailActivity(v: View) {
        val intent = Intent(v.context, ContactDetailActivity::class.java).apply {
            putExtra(ContactDetailFragment.ARG_CONTACT, v.tag as ContactModel)
        }
        v.context.startActivity(intent)
    }

    private fun updateFragment(v: View) {
        val fragment = ContactDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ContactDetailFragment.ARG_CONTACT, v.tag as ContactModel)
            }
        }
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.contact_detail_container, fragment)
                .commit()
    }

    private fun setupView() {
        contact_list.adapter = contactsAdapter

        setSupportActionBar(toolbar)
        toolbar.title = title

        contact_detail_container?.let { twoPane = true }
    }
}
