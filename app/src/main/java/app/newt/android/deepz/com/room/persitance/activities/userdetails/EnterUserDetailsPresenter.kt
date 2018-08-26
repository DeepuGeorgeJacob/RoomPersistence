package app.newt.android.deepz.com.room.persitance.activities.userdetails

import android.arch.persistence.room.Room.databaseBuilder
import android.text.TextUtils
import app.newt.android.deepz.com.archetecture.mvp.context.IContext
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.database.UserDataBase

class EnterUserDetailsPresenter(view: EnterUserDetailsContract.View, context: IContext) : EnterUserDetailsContract.Presenter {
    private val view = view
    private val context = context
    private val DATABASE_NAME = "user_db"
    private lateinit var userDB: UserDataBase
    override fun start() {
        userDB = databaseBuilder(context.getApplicationContext(), UserDataBase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
        view.setPresenter(this)
    }

    override fun onSaveInteracted() {
        val username =view.getUsername()
        val email = view.getEmail()
        val phonenumber = view.getPhoneNumber()
        if(isEmpty(username)) {
            view.showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.name_hint))
            return
        }
        if(isEmpty(email)) {
            view.showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.email_hint))
            return
        }
        if(isEmpty(phonenumber)) {
            view.showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.phone_hint))
            return
        }

    }
}