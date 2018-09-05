package app.newt.android.deepz.com.room.persitance.activities.userlist.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import app.newt.android.deepz.com.room.persitance.R

class UserItemHolder(v: View) : RecyclerView.ViewHolder(v) {
    public lateinit var id: TextView
    public lateinit var name: TextView
    public lateinit var email: TextView
    public lateinit var phone: TextView

    init {
        id = v.findViewById(R.id.id_tv)
        name = v.findViewById(R.id.id_name)
        phone = v.findViewById(R.id.id_phones)
        email = v.findViewById(R.id.id_email)
    }

}