package app.newt.android.deepz.com.archetecture.mvp.context

import android.content.Context

class MVPContext(context: Context) : IContext {
    private val cxt = context
    override fun getString(id: Int): String {
        return cxt.getString(id)
    }


    override fun getContext(): Context {
        return cxt
    }

    override fun getApplicationContext(): Context {
        return cxt.applicationContext
    }
}