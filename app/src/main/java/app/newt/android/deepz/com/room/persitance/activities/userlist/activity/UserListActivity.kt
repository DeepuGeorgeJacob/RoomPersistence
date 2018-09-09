package app.newt.android.deepz.com.room.persitance.activities.userlist.activity

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import app.newt.android.deepz.com.archetecture.mvp.context.MVPContext
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.activities.main.BaseActivity
import app.newt.android.deepz.com.room.persitance.activities.userlist.activity.UserListContract.View
import app.newt.android.deepz.com.room.persitance.activities.userlist.adapter.UserItemAdapter
import app.newt.android.deepz.com.room.persitance.entities.User
import kotlinx.android.synthetic.main.activity_user_list.*

class UserListActivity : BaseActivity(), View {
    private lateinit var adapter: UserItemAdapter
    private lateinit var presenter: UserListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        user_list.layoutManager = LinearLayoutManager(this)
        UserListPresenter(this, getDataBase(),MVPContext(this)).start()
    }
    override fun updateAdapter(user: User) {
        runOnUiThread {
            adapter.removeDeletedUser(user)
        }
    }

    override fun setAdapter(userList: List<User>) {
        runOnUiThread {
            adapter = UserItemAdapter(userList)
            user_list.adapter = adapter
            adapter.setClickListener(object : UserItemAdapter.ItemClickListener {
                override fun selectedItem(user: User?) {
                   presenter.userItemSelected(user!!)
                }
            })

        }
    }
    override fun showEditDeleteDialog(user: User, title: String, body: String, editButtonText: String, deleteButtonText: String) {
        showDialog(title, body, editButtonText, deleteButtonText, DialogInterface.OnClickListener { _, _
            ->
            dismissDialog()
        }, DialogInterface.OnClickListener { _, _
            ->
            presenter.deleteUser(user)
        })
    }

    override fun setPresenter(presenter: UserListContract.Presenter) {
        this.presenter = presenter
    }
}
