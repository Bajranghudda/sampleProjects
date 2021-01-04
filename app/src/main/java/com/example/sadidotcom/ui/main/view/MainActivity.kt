package com.example.sadidotcom.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sadidotcom.R
import com.example.sadidotcom.data.model.Person
import com.example.sadidotcom.databinding.ActivityMainBinding
import com.example.sadidotcom.ui.main.adapter.PersonAdapter
import com.example.sadidotcom.ui.main.viewmodel.MainViewModel
import com.example.sadidotcom.uitls.binding.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel by viewModel<MainViewModel>()
    private lateinit var personAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpViewBinding()
        setupUI()
        setupObserver()
    }

    private fun setUpViewBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }

    private fun setupUI() {
        personAdapter = PersonAdapter(arrayListOf(), viewModel)
        binding.rvPeople.adapter = personAdapter
    }

    private fun setupObserver() {
        viewModel.people.observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { people -> retrieveList(people as ArrayList<Person>) }
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun retrieveList(people: ArrayList<Person>) {
        personAdapter.apply {
            addPeople(people)
            notifyDataSetChanged()
        }
    }

}