package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.ResultWrapper
import com.example.dagger_with_room_retrofit_base_on_reqres.core.ui.NetworkState
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.data.repository.UserRepository
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.model.UserView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _users = MutableLiveData<List<UserView>?>()
    val users: LiveData<List<UserView>?> = _users

    private val _loadSate = MutableLiveData(NetworkState.INITIAL_STATE)
    val loadSate: LiveData<NetworkState> = _loadSate

    private val _loadSateMessage = MutableLiveData<String>()
    val loadStateMessate: LiveData<String> = _loadSateMessage

    init {
        fetch()
    }

    fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            val repositoryResponse = userRepository.getUsersData()

            withContext(Dispatchers.Main) {
                when (repositoryResponse) {
                    is ResultWrapper.AppError -> {
                        _users.value = repositoryResponse.data
                        _loadSateMessage.value = repositoryResponse.appMessage
                        _loadSate.value = NetworkState.APPERROR
                    }

                    is ResultWrapper.Failure -> {
                        _users.value = repositoryResponse.data
                        _loadSateMessage.value =
                            "${repositoryResponse.code} : ${repositoryResponse.severMessage}"
                        _loadSate.value = NetworkState.FAILURE
                    }

                    is ResultWrapper.Success -> {
                        _users.value = repositoryResponse.data
                        _loadSate.value = NetworkState.SUCCESS
                    }
                }
            }
        }
    }

}