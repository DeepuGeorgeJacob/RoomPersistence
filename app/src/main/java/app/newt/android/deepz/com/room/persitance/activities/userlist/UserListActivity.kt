package app.newt.android.deepz.com.room.persitance.activities.userlist

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.activities.main.BaseActivity
import app.newt.android.deepz.com.room.persitance.activities.userlist.adapter.UserItemAdapter
import kotlin.concurrent.thread

class UserListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        val recyclerView = findViewById<RecyclerView>(R.id.user_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        thread {
            val userList = getDataBase().getDataAccess().selectAllUsers()
            Handler(Looper.getMainLooper()).post {
                recyclerView.adapter = UserItemAdapter(userList)
            }
        }


    }
}
