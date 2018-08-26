package app.newt.android.deepz.com.archetecture.mvp.mv

interface BaseView<T : BasePresenter> {
    fun setPresenter(presenter: T)
}