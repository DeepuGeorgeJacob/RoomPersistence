package app.newt.android.deepz.com.archetecture.mvp.context

import android.content.Context
import java.io.InputStream

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

    override fun getAssetsByOpen(assetPath: String): InputStream {
        return cxt.assets.open(assetPath)
    }
}