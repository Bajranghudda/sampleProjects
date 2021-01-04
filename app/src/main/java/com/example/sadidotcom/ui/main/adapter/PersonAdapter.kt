package com.example.sadidotcom.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sadidotcom.R
import com.example.sadidotcom.data.model.Person
import com.example.sadidotcom.databinding.ItemPersonBinding
import com.example.sadidotcom.ui.main.viewmodel.MainViewModel

class PersonAdapter(
    var people: ArrayList<Person> = arrayListOf(),
    val vm: MainViewModel
) : RecyclerView.Adapter<PersonAdapter.PersonListingViewHolder>() {
    var mContext: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonListingViewHolder {
        return PersonListingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_person,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PersonListingViewHolder, position: Int) {
        holder.binding.person = people[position]
        //holder.binding.vm = vm
        holder.binding.btAccept.setOnClickListener {
            handleViewVisibility(holder, isDeclined = false, position = position)
        }

        holder.binding.btDecline.setOnClickListener {
            handleViewVisibility(holder, isDeclined = true, position = position)
        }
    }

    override fun getItemCount() = people.size

    fun addPeople(people: ArrayList<Person>) {
        this.people.apply {
            clear()
            addAll(people)
        }
    }

    class PersonListingViewHolder(view: View) : BindingViewHolder<ItemPersonBinding>(view)

    private fun handleViewVisibility(
        holder: PersonListingViewHolder,
        isDeclined: Boolean,
        position: Int
    ) {
        vm.setCardDeclined(isDeclined = isDeclined, personId = people[position].personId)
        people[position].isChangeDone = true
        people[position].isDeclined = isDeclined
        //todo we can put observer in case of callback

        holder.binding.btDecline.visibility = View.GONE
        holder.binding.btAccept.visibility = View.GONE
        holder.binding.tvCardStatus.visibility = View.VISIBLE
        holder.binding.tvCardStatus.text =
            if (isDeclined) holder.binding.tvCardStatus.context.getString(R.string.member_declined) else holder.binding.tvCardStatus.context.getString(
                R.string.member_accpted
            )
    }
}