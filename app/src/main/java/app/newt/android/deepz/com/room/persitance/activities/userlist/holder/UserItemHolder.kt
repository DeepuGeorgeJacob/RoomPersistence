package app.newt.android.deepz.com.room.persitance.activities.userlist.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import app.newt.android.deepz.com.room.persitance.R

class UserItemHolder(v: View) : RecyclerView.ViewHolder(v) {
    var id: TextView = v.findViewById(R.id.id_tv)
    var name: TextView = v.findViewById(R.id.id_name)
    var email: TextView = v.findViewById(R.id.id_email)
    var phone: TextView = v.findViewById(R.id.id_phones)
    var card :View = v.findViewById(R.id.card_view)

}