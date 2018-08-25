package app.newt.android.deepz.com.room.persitance.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.math.BigInteger

@Entity(tableName = "user")
data class User(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "phonenumber") var phonenumber: String,
        @ColumnInfo(name = "email") var email: String) {
    constructor() : this(null, "", "", "")

}