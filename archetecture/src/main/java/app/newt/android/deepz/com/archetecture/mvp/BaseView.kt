package app.newt.android.deepz.com.archetecture.mvp

interface BaseView<T : BasePresenter> {
    fun setPresenter(presenter: T)
}