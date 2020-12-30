package info.meysam.coverto.webservice

import hivatec.ir.hivatectools.helper.G
import info.meysam.coverto.helpers.common.NetworkConnectionInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


class ApiHelper {

    companion object {
        const val BASE_URL = "https://meysam.info/covertoapp/"


        var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(NetworkConnectionInterceptor(G.context))
            .build()


        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        var myApiInterface = retrofit.create(ApiEndpointInterface::class.java)


    }
}