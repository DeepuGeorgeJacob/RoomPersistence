package app.newt.android.deepz.com.room.persitance.activities.userlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.activities.userlist.holder.UserItemHolder
import app.newt.android.deepz.com.room.persitance.entities.User

class UserItemAdapter(userList: List<User>) : RecyclerView.Adapter<UserItemHolder>() {
    private val userList = userList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemHolder {
        return UserItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_list_item,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.count()
    }

    override fun onBindViewHolder(holder: UserItemHolder, position: Int) {
        val user = userList[position]
        holder.id.text = user.id.toString()
        holder.email.text = user.email
        holder.phone.text = user.phonenumber
        holder.name.text = user.name

    }
}