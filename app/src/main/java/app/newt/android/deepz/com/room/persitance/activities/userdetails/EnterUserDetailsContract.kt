package app.newt.android.deepz.com.room.persitance.activities.userdetails

import app.newt.android.deepz.com.archetecture.mvp.BasePresenter
import app.newt.android.deepz.com.archetecture.mvp.BaseView

interface EnterUserDetailsContract {
    interface View:BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {
            fun onSaveInteracted()
    }
}