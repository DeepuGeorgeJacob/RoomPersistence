package app.newt.android.deepz.com.room.persitance.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import app.newt.android.deepz.com.room.persitance.entities.User

@Dao
interface DataAccess {
    @Insert
    fun insertUser(user: User)

    @Insert(onConflict = REPLACE)
    fun insertListOfUsers(userlist: List<User>)

    @Update(onConflict = REPLACE)
    fun updateUser(user: User)

    @Update(onConflict = REPLACE)
    fun updateListOfUsers(userlist: List<User>)

    @Delete
    fun deleteUser(user: User)

    @Delete
    fun deleteUsers(userlist: List<User>)

    @Query("SELECT * FROM USER")
    fun selectAllUsers(): List<User>

    @Query("SELECT * FROM user WHERE id=:id")
    fun selectUser(id: Int): User
}