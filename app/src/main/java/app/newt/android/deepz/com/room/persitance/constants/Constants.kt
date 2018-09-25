package app.newt.android.deepz.com.room.persitance.constants

import app.newt.android.deepz.com.archetecture.mvp.context.IContext
import app.newt.android.deepz.com.room.persitance.BuildConfig
import java.io.IOException


class Constants private constructor() {
    private object Holder {
        val INSTANCE = Constants()
    }

    companion object {
        val instance: Constants by lazy { Holder.INSTANCE }
    }

    var context: IContext? = null


    private val constants_path = BuildConfig.Constants!!
    fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val `is` = context!!.getAssetsByOpen(constants_path)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    init {
        val loadJSONFromAsset = loadJSONFromAsset()
    }
}