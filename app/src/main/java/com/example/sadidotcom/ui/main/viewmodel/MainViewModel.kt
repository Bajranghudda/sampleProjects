package com.example.sadidotcom.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sadidotcom.data.model.repository.PersonRepository
import com.example.sadidotcom.uitls.binding.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(val personRepository: PersonRepository) : ViewModel() {

    val people = personRepository.people

    fun setCardDeclined(isDeclined: Boolean, personId: Long) =
        liveData(Dispatchers.IO) {
            try {
                emit(
                    personRepository.updateCard(
                        isDeclined = isDeclined,
                        personId = personId
                    )
                )
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }
}