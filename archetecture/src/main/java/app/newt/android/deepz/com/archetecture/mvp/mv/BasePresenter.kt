package app.newt.android.deepz.com.archetecture.mvp.mv


interface BasePresenter {
    fun start()
    fun isEmpty(input: String?): Boolean {
        return input == null || input.trim().isEmpty()
    }
}