package app.newt.android.deepz.com.room.persitance.activities.userdetails

import app.newt.android.deepz.com.archetecture.mvp.context.IContext
import app.newt.android.deepz.com.archetecture.mvp.utils.isEmpty
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.database.IDatabase
import app.newt.android.deepz.com.room.persitance.entities.User

class EnterUserDetailsPresenter(view: EnterUserDetailsContract.View, context: IContext,dataBase: IDatabase) : EnterUserDetailsContract.Presenter {
    private val view = view
    private val context = context

    private  val userDB: IDatabase = dataBase
    override fun start() {
        view.setPresenter(this)
    }

    override fun onSaveOrUpdateInteracted() {
        val username = view.getUsername()
        val email = view.getEmail()
        val phonenumber = view.getPhoneNumber()
        if (isEmpty(username)) {
            view.showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.name_hint))
            return
        }
        if (isEmpty(email)) {
            view.showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.email_hint))
            return
        }
        if (isEmpty(phonenumber)) {
            view.showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.phone_hint))
            return
        }
        Thread {
            val user = User(null, username, email, phonenumber)
             userDB.getDataAccess().insertUser(user)
            view.navigateToList()
        }.start()

    }
}