package info.meysam.coverto.helpers

import android.content.Context
import androidx.multidex.MultiDex
import hivatec.ir.hivatectools.helper.G

class Global : G() {


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}