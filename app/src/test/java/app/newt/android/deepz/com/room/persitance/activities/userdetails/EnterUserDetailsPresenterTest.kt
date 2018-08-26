package app.newt.android.deepz.com.room.persitance.activities.userdetails

import android.content.Context
import app.newt.android.deepz.com.archetecture.mvp.context.IContext
import app.newt.android.deepz.com.room.persitance.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EnterUserDetailsPresenterTest {
    private var presenter: EnterUserDetailsPresenter? = null
    private val view: EnterUserDetailsContract.View = mock(EnterUserDetailsContract.View::class.java)
    private val context: IContext = mock(IContext::class.java)
    private val cxt = mock(Context::class.java)
    @Before
    fun setUp() {
        presenter = EnterUserDetailsPresenter(view, context)
        `when`(context.getString(R.string.please) ).thenReturn("Please")
    }


    @Test
    fun test_start() {
        `when`(context.getApplicationContext()).thenReturn(cxt)
        presenter!!.start()
        verify(view).setPresenter(presenter!!)
    }

    @Test
    fun test_onSaveInteracted_empty_username() {
        `when`(view.getUsername()).thenReturn(null)
        `when`(context.getString(R.string.name_hint)).thenReturn("Enter name")
        presenter!!.onSaveInteracted()
        verify(view).showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.name_hint))

    }
    @Test
    fun test_onSaveInteracted_empty_email() {
        `when`(view.getUsername()).thenReturn("Deepu")
        `when`(view.getEmail()).thenReturn(null)
        `when`(context.getString(R.string.email_hint)).thenReturn("Enter email address")
        presenter!!.onSaveInteracted()
        verify(view).showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.email_hint))

    }

    @Test
    fun test_onSaveInteracted_empty_phone() {
        `when`(view.getUsername()).thenReturn("Deepu")
        `when`(view.getEmail()).thenReturn("123@gmail.com")
        `when`(view.getPhoneNumber()).thenReturn(null)
        `when`(context.getString(R.string.phone_hint)).thenReturn("Enter phone number")
        presenter!!.onSaveInteracted()
        verify(view).showErrorMessage(context.getString(R.string.please) + " " + context.getString(R.string.phone_hint))

    }

    @After
    fun tearDown() {
        presenter = null

    }
}