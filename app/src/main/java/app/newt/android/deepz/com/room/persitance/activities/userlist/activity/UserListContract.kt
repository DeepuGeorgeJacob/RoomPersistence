package app.newt.android.deepz.com.room.persitance.activities.userlist.activity

import app.newt.android.deepz.com.archetecture.mvp.mv.BasePresenter
import app.newt.android.deepz.com.archetecture.mvp.mv.BaseView
import app.newt.android.deepz.com.room.persitance.entities.User

interface UserListContract {
    interface View : BaseView<Presenter> {
        fun setAdapter(userList: List<User>)
        fun updateAdapter(user: User)
        fun dismissDialog()
        fun showEditDeleteDialog(user: User, title: String, body: String, editButtonText: String, deleteButtonText: String)
    }

    interface Presenter : BasePresenter {
        fun deleteUser(user: User)
        fun userItemSelected(user: User)
    }
}