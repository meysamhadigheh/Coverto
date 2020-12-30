package info.meysam.coverto.ui.activities

import android.content.Intent
import android.view.animation.AnimationUtils
import androidx.room.Room
import info.meysam.coverto.R
import info.meysam.coverto.data.OrderDatabase
import info.meysam.coverto.helpers.SharedObjects
import info.meysam.coverto.helpers.common.NetworkConnectionInterceptor
import info.meysam.coverto.ui.dialogs.InternetDialog
import info.meysam.coverto.webservice.ApiHelper
import info.meysam.coverto.webservice.CardsResponse
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashActivity : BaseActivity() {

    var dataReceived = false;
    var database: OrderDatabase? = null


    override fun setContentViewActivity() {

        setContentView(R.layout.activity_splash)

    }


    override fun getIntentData() {
    }

    override fun instantiateViews() {

        animation.setAnimation(R.raw.lf20_dy2leguq)


        titleTxt.text = " COVERTO "

        var animation = AnimationUtils.loadAnimation(this, R.anim.anim)
        titleTxt.startAnimation(animation)


    }

    override fun setViewListeners() {
    }

    override fun setActivityContent() {

        fetchCards()


        val handler = android.os.Handler()

        handler.postDelayed({

            if (dataReceived) {

                startActivity(Intent(context, MainActivity::class.java))
                finish()

            }


        }, 3500)

    }

    fun fetchCards() {


        ApiHelper.myApiInterface.allCards(


        ).also {

            it.enqueue(object : Callback<CardsResponse>, InternetDialog.ClickListener {

                override fun onResponse(
                    call: Call<CardsResponse>,
                    response: Response<CardsResponse>
                ) {


                    if (response.body() != null) {

                        SharedObjects.setCardsList(response.body()?.cards?.getValue("متفرقه")!!)

                        dataReceived = true

                    } else {


                    }


                }

                override fun onFailure(call: Call<CardsResponse>, t: Throwable) {


                    if (t is NetworkConnectionInterceptor.NoConnectivityException) {
                        // show No Connectivity message to user or do whatever you want.
                        val dialog = InternetDialog()

                        dialog.listener = this

                        supportFragmentManager.let { it1 -> dialog.show(it1, dialog.tag) }

                    }

                }

                override fun internetExitClicked() {
                    finish()

                }

                override fun internetRetryClicked() {

                    fetchCards()
                }

            })


        }


    }

}