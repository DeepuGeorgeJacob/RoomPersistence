package app.newt.android.deepz.com.room.persitance.activities.userlist.activity

import app.newt.android.deepz.com.archetecture.mvp.context.IContext
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.dao.DataAccess
import app.newt.android.deepz.com.room.persitance.database.IDatabase
import app.newt.android.deepz.com.room.persitance.entities.User
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class UserListPresenterTest {
    private  var userListPresenter: UserListPresenter? = null
    private val view = Mockito.mock(UserListContract.View::class.java)
    private val database = Mockito.mock(IDatabase::class.java)
    private var context:IContext = Mockito.mock(IContext::class.java)
    @Before
    fun setUp() {
        Mockito.`when`(database.getDataAccess()).thenReturn(Mockito.mock(DataAccess::class.java))
        userListPresenter = UserListPresenter(view,database,context)
    }

    @After
    fun tearDown() {
        userListPresenter = null
    }

    @Test
    fun test_start() {
        val list = getMockUserList()
        Mockito.`when`(database.getDataAccess().selectAllUsers()).thenReturn(list)
        userListPresenter!!.start()
        Thread.sleep(200)
        Mockito.verify(view).setAdapter(list)

    }
    @Test
    fun test_deleteUser() {
        val user = User(0,"User","55545454","abc@ffjnj.com")
        userListPresenter!!.deleteUser(user)
        Mockito.verify(view).dismissDialog()
        Thread.sleep(200)
        Mockito.verify(view).updateAdapter(user)
    }
    @Test
    fun test_userItemSelected() {
        val user = User(0,"User","55545454","abc@ffjnj.com")
        Mockito.`when`( context.getString(R.string.edit_delete_dialog_title)).thenReturn("title")
        Mockito.`when`( context.getString(R.string.edit_delete_dialog_message)).thenReturn("message")
        Mockito.`when`( context.getString(R.string.edit_delete_dialog_edit_text)).thenReturn("Edit")
        Mockito.`when`( context.getString(R.string.edit_delete_dialog_delete_text)).thenReturn("Delete")
        userListPresenter!!.userItemSelected(user)
        Mockito.verify(view).showEditDeleteDialog(user,"title","message","Edit","Delete")

    }

    private fun getMockUserList():List<User> {
        return listOf(User(3,"Test","34534","abc@ffjnj554.com"))
    }
}