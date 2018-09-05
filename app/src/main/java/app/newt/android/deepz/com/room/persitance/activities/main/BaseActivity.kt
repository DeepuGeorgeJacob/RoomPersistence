
package app.newt.android.deepz.com.room.persitance.activities.main

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.newt.android.deepz.com.room.persitance.database.IDatabase
import app.newt.android.deepz.com.room.persitance.database.UserDataBase

open class BaseActivity : AppCompatActivity() {
    private val DATABASE_NAME = "user_db"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun getDataBase():IDatabase {
        return Room.databaseBuilder(applicationContext, UserDataBase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
    }
}
