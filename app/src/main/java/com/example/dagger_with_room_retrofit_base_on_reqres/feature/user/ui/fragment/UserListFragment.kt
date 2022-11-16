package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_with_room_retrofit_base_on_reqres.R
import com.example.dagger_with_room_retrofit_base_on_reqres.core.di.DaggerNetworkComponent
import com.example.dagger_with_room_retrofit_base_on_reqres.core.ui.NetworkState
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.di.component.DaggerUserComponent
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.adapter.RecyclerAdapter_UserListFragment
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.viewModel.UserViewModel
import javax.inject.Inject

class UserListFragment : Fragment() {

    @Inject
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

      override fun onAttach(context: Context) {
          super.onAttach(context)
          val networkComponent = DaggerNetworkComponent.factory().create()
          networkComponent
          DaggerUserComponent.factory().create(
              networkComponent = networkComponent
          ).inject(this)
      }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_users_userListFragment)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        userViewModel.loadSate.observe(viewLifecycleOwner) { networkState ->
            when (networkState) {
                NetworkState.SUCCESS -> {
                    val adapter = RecyclerAdapter_UserListFragment(
                        userViewModel.users.value ?: listOf()
                    )
                }
                NetworkState.FAILURE -> {}
                NetworkState.APPERROR -> {}
                NetworkState.INITIAL_STATE -> {}
            }

        }*/


    }


}