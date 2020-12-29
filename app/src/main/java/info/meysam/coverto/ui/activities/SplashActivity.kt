package info.meysam.coverto.ui.activities

import android.content.Intent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import info.meysam.coverto.R
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : BaseActivity() {

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

        val handler = android.os.Handler()

        handler.postDelayed({

            startActivity(Intent(context, MainActivity::class.java))
            finish()

        }, 3500)

    }
}