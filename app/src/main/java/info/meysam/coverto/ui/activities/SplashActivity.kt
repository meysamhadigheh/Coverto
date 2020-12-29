package info.meysam.coverto.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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