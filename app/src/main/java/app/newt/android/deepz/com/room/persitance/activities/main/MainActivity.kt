package app.newt.android.deepz.com.room.persitance.activities.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.activities.userdetails.EnterUserDetailsActivity
import app.newt.android.deepz.com.room.persitance.activities.userlist.UserListActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.enter_details_button).setOnClickListener(this)
        findViewById<View>(R.id.show_user_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.enter_details_button -> {
                //Navigate to enter details screen
                startActivity(Intent(this, EnterUserDetailsActivity::class.java))
            }
            R.id.show_user_button -> {
                //Show recycler view
                startActivity(Intent(this,UserListActivity::class.java))
            }

        }
    }

}
