package info.meysam.coverto.helpers.common

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


/**
 *
 */
class NetworkConnectionInterceptor(val mContext: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected) {


            /* val handler = Handler(Looper.getMainLooper())

            handler.postDelayed({


            }, 0)


*/
            throw NoConnectivityException()

            // Throwing our custom exception 'NoConnectivityException'
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    /**
     *
     */
    val isConnected: Boolean
        get() {
            val connectivityManager =
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = connectivityManager.activeNetworkInfo
            return netInfo != null && netInfo.isConnected
        }

    /**
     *
     */
    inner class NoConnectivityException : IOException() {

        // You can send any message whatever you want from here.
        override val message: String
            get() = "No Internet Connection"

        // You can send any message whatever you want from here.
    }


}