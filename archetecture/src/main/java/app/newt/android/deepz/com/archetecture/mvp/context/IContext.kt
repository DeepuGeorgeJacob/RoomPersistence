package app.newt.android.deepz.com.archetecture.mvp.context

import android.content.Context
import java.io.InputStream

interface IContext {
    fun getContext(): Context
    fun getApplicationContext(): Context
    fun getString(id: Int): String
    fun getAssetsByOpen(assetPath:String):InputStream
}