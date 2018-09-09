package app.newt.android.deepz.com.room.persitance.activities.userlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.activities.userlist.holder.UserItemHolder
import app.newt.android.deepz.com.room.persitance.entities.User

class UserItemAdapter(userList: List<User>) : RecyclerView.Adapter<UserItemHolder>() {
    private val userList = userList
    private var itemClickListener: ItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemHolder {
        return UserItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_list_item,parent,false))
    }
    fun removeDeletedUser(user:User) {
        (userList as ArrayList<User>).remove(user)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.count()
    }
     fun setClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }


    override fun onBindViewHolder(holder: UserItemHolder, position: Int) {
        val user = userList[position]
        holder.id.text = user.id.toString()
        holder.email.text = user.email
        holder.phone.text = user.phonenumber
        holder.name.text = user.name
        holder.card.setOnClickListener { 
            itemClickListener!!.selectedItem(user)
        }

    }

    interface ItemClickListener {
        fun selectedItem(user: User?)
        }
}