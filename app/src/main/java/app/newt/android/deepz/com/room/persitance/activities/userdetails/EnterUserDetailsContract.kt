package app.newt.android.deepz.com.room.persitance.activities.userdetails

import app.newt.android.deepz.com.archetecture.mvp.mv.BasePresenter
import app.newt.android.deepz.com.archetecture.mvp.mv.BaseView

interface EnterUserDetailsContract {
    interface View : BaseView<Presenter> {
        fun getUsername(): String
        fun getEmail(): String
        fun getPhoneNumber(): String
        fun showErrorMessage(error:String)
    }

    interface Presenter : BasePresenter {
        fun onSaveInteracted()
    }
}