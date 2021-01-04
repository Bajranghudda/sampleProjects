package com.example.sadidotcom.uitls.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sadidotcom.R
import com.example.sadidotcom.data.model.Person
import com.example.sadidotcom.ui.main.adapter.PersonAdapter
import com.example.sadidotcom.ui.main.viewmodel.MainViewModel
import com.squareup.picasso.Picasso

//todo handle item adding from here only
@BindingAdapter(value = ["people", "viewModel"])
fun setContents(view: RecyclerView, people: ArrayList<Person>, vm: MainViewModel) {
    view.adapter?.run {
        if (this is PersonAdapter) {
            this.people = people
            this.notifyDataSetChanged()
        }
    } ?: run {
        PersonAdapter(people, vm).apply { view.adapter = this }
    }
}

@BindingAdapter(value = ["imageUrl"])
fun setImageUrl(view: ImageView, imageUrl: String) {
    Picasso.get()
        .load(imageUrl)
        .placeholder(R.mipmap.ic_launcher) //todo change with a proper placeholder
        .into(view)
}