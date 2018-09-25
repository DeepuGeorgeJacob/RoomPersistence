package app.newt.android.deepz.com.room.persitance.activities.userdetails

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import app.newt.android.deepz.com.archetecture.mvp.context.MVPContext
import app.newt.android.deepz.com.room.persitance.R
import app.newt.android.deepz.com.room.persitance.activities.main.BaseActivity
import kotlinx.android.synthetic.main.activity_enter_user_details.*

class EnterUserDetailsActivity : BaseActivity(), EnterUserDetailsContract.View {


    private lateinit var presenter: EnterUserDetailsContract.Presenter
    private lateinit var nameView: EditText
    private lateinit var emailView:EditText
    private lateinit var phoneNumberView:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_user_details)
       nameView =  findViewById(R.id.name_edit_text)
        emailView = findViewById(R.id.email_edit_text)
        phoneNumberView = findViewById(R.id.phone_number_edit_text)
        save.setOnClickListener {
            presenter.onSaveOrUpdateInteracted()
        }
        EnterUserDetailsPresenter(this, MVPContext(this), getDataBase()).start()
    }

    override fun setPresenter(presenter: EnterUserDetailsContract.Presenter) {
        this.presenter = presenter
    }

    override fun getUsername(): String {
        return nameView.text.toString()
    }

    override fun getEmail(): String {
        return emailView.text.toString()
    }

    override fun getPhoneNumber(): String {
        return phoneNumberView.text.toString()
    }
    override fun navigateToList() {
        this.assets
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}
