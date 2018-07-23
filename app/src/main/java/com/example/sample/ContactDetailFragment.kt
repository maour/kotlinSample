package com.example.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sample.data.ContactModel
import kotlinx.android.synthetic.main.activity_contact_detail.*
import kotlinx.android.synthetic.main.contact_detail.view.*

class ContactDetailFragment : Fragment() {

    private var person: ContactModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_CONTACT)) {
                person = it.getParcelable(ARG_CONTACT)

                activity?.toolbar_layout?.title = "${person?.name}  Info"
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.contact_detail, container, false)

        person?.let {
            val message = ""

            it.firstName?.let {
                message.plus("Contact FirstName= $it")
            }
            it.lastName?.let {
                message.plus("Contact LastName= $it")
            }

            rootView.item_detail.text = if (message.isEmpty()) "No FirstName or LastName" else message
        }

        return rootView
    }

    companion object {
        const val ARG_CONTACT = "person"
    }
}
