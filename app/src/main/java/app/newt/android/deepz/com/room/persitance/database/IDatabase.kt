package app.newt.android.deepz.com.room.persitance.database

import app.newt.android.deepz.com.room.persitance.dao.DataAccess

interface IDatabase {
    fun getDataAccess(): DataAccess
}