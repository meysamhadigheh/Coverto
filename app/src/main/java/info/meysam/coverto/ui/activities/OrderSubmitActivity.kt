package info.meysam.coverto.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import info.meysam.coverto.R
import info.meysam.coverto.data.models.Order
import info.meysam.coverto.helpers.ORDERINFO
import info.meysam.coverto.helpers.ORDERSUBMITTED
import info.meysam.coverto.helpers.SharedObjects
import kotlinx.android.synthetic.main.activity_order_submit.*

class OrderSubmitActivity : BaseActivity() {


    var order = Order()


    override fun setContentViewActivity() {

        setContentView(R.layout.activity_order_submit)

    }

    override fun getIntentData() {

        order = Gson().fromJson(intent.getStringExtra(ORDERINFO), Order::class.java)
    }

    override fun instantiateViews() {

        edt_name.setText(SharedObjects.getName_t())
        edt_family.setText(SharedObjects.getFamily_t())
        edt_address.setText(SharedObjects.getAddress_t())
        edt_mobile.setText(SharedObjects.getPhone_t())
    }

    override fun setViewListeners() {

        submit.setOnClickListener {
            submitOrder()
        }
    }


    override fun setActivityContent() {
    }

    private fun submitOrder() {

        order.name = edt_name.text.toString()
        order.family = edt_family.text.toString()
        order.address = edt_address.text.toString()
        order.phone = edt_mobile.text.toString()
        order.description = edt_desc.text.toString()

        MainActivity.database?.orderDao()?.insert(order)

        submit.startLoadingState()

        val handler = android.os.Handler()

        handler.postDelayed({

            setResult(ORDERSUBMITTED)
            finish()

        }, 1000)

    }
}