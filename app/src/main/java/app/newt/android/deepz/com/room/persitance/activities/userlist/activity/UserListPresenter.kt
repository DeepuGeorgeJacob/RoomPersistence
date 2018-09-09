package app.newt.android.deepz.com.room.persitance.activities.userlist.activity

import app.newt.android.deepz.com.archetecture.mvp.context.IContext
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.activities.userlist.activity.UserListContract.Presenter
import app.newt.android.deepz.com.room.persitance.database.IDatabase
import app.newt.android.deepz.com.room.persitance.entities.User
import kotlin.concurrent.thread

class UserListPresenter(view: UserListContract.View, database: IDatabase, context: IContext) : Presenter {
    val database = database
    val view = view
    val context = context
    override fun deleteUser(user: User) {
        view.dismissDialog()
        thread {
            database.getDataAccess().deleteUser(user)
            view.updateAdapter(user)
        }

    }

    override fun start() {
        view.setPresenter(this)
        thread {
            val userList = database.getDataAccess().selectAllUsers()
            view.setAdapter(userList)
        }
    }

    override fun userItemSelected(user: User) {
        view.showEditDeleteDialog(user, context.getString(R.string.edit_delete_dialog_title),
                context.getString(R.string.edit_delete_dialog_message),
                context.getString(R.string.edit_delete_dialog_edit_text),
                context.getString(R.string.edit_delete_dialog_delete_text))
    }
}