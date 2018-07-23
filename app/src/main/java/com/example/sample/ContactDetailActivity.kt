package com.example.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_contact_detail.*

class ContactDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        setSupportActionBar(detail_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val fragment = ContactDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ContactDetailFragment.ARG_CONTACT,
                            intent.getParcelableExtra(ContactDetailFragment.ARG_CONTACT))
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.contact_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> {
                    navigateUpTo(Intent(this, ContactsListActivity::class.java))
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
}
