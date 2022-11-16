package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.di.component

import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.di.NetworkComponent
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.di.module.UserModules
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.adapter.RecyclerAdapter_UserListFragment
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.fragment.UserListFragment
import dagger.Component

@Component(
    modules = [UserModules::class],
    dependencies = [NetworkComponent::class]
)
interface UserComponent {
    fun inject(userListFragment: UserListFragment)
    @Component.Factory
    interface Factory{
        fun create(
            networkComponent: NetworkComponent
        ): UserComponent
    }
}
