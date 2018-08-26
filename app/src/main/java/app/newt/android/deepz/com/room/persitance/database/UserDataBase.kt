package app.newt.android.deepz.com.room.persitance.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.newt.android.deepz.com.room.persitance.dao.DataAccess
import app.newt.android.deepz.com.room.persitance.entities.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun getDataAccess():DataAccess
}