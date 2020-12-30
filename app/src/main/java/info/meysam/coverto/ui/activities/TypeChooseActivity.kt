package info.meysam.coverto.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import info.meysam.coverto.R
import info.meysam.coverto.data.models.Order
import info.meysam.coverto.helpers.CARDINFO
import info.meysam.coverto.helpers.ORDERINFO
import info.meysam.coverto.helpers.ORDERSUBMITTED
import info.meysam.coverto.helpers.caseType
import kotlinx.android.synthetic.main.activity_type_choose.*
import kotlinx.android.synthetic.main.dialog_internet.*

class TypeChooseActivity : BaseActivity(), View.OnClickListener {


    var order: Order? = Order()


    override fun setContentViewActivity() {

        setContentView(R.layout.activity_type_choose)

    }

    override fun getIntentData() {

        order = Gson().fromJson(intent.getStringExtra(ORDERINFO), Order::class.java)
    }

    override fun instantiateViews() {
    }

    override fun setViewListeners() {

        TWO_D.setOnClickListener(this)
        THREE_D.setOnClickListener(this)
    }

    override fun setActivityContent() {
    }

    override fun onClick(v: View?) {

        when (v) {
            TWO_D -> {

                order?.case = caseType.TWO_D.toString()

            }

            THREE_D -> {
                order?.case = caseType.THREE_D.toString()

            }
            else -> {

            }
        }.also {
            val intent = Intent(context, OrderSubmitActivity::class.java)
            intent.putExtra(ORDERINFO, Gson().toJson(order))
            startActivityForResult(intent, ORDERSUBMITTED)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode== ORDERSUBMITTED){
            setResult(resultCode)
            finish()
        }
    }
}