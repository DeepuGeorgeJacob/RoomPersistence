package app.newt.android.deepz.com.room.persitance.activities.userdetails

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import app.newt.android.deepz.com.room.persitance.R

class EnterUserDetailsActivity : AppCompatActivity(), EnterUserDetailsContract.View {
    private lateinit var presenter: EnterUserDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_user_details)
        findViewById<Button>(R.id.save).setOnClickListener {
            presenter.onSaveInteracted()
        }
        EnterUserDetailsPresenter(this).start()
    }

    override fun setPresenter(presenter: EnterUserDetailsContract.Presenter) {
        this.presenter = presenter
    }
}
