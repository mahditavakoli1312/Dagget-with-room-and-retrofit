package com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.adapter

import android.provider.CalendarContract.Colors
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_with_room_retrofit_base_on_reqres.R
import com.example.dagger_with_room_retrofit_base_on_reqres.feature.user.ui.model.UserView

class RecyclerAdapter_UserListFragment(
    private val contentList: List<UserView>
) : RecyclerView.Adapter<RecyclerAdapter_UserListFragment.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout =
            itemView.findViewById<LinearLayout>(R.id.ll_backColor_recycler_user_card_user_fragment)
        val user_name_holder =
            itemView.findViewById<TextView>(R.id.tv_userName_recycler_user_card_user_fragment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_user_card_user_fragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = contentList[position]

        holder.user_name_holder.setText(
            content.name
        )
    }

    override fun getItemCount(): Int {
        return contentList.size
    }
}