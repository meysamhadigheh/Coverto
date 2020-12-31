package info.meysam.coverto.ui.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.gson.Gson
import info.meysam.coverto.R
import info.meysam.coverto.data.models.Order
import info.meysam.coverto.helpers.ORDERINFO
import info.meysam.coverto.helpers.orderStatus
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.item_card.view.*

class OrderDetailsActivity : BaseActivity() {


    var order: Order? = null

    override fun setContentViewActivity() {

        setContentView(R.layout.activity_order_details)

    }

    override fun getIntentData() {

        order = Gson().fromJson(intent.getStringExtra(ORDERINFO), Order::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun instantiateViews() {
        submit_code.text = " کد سفارش: " +order?.id.toString()
        status.text = orderState()
        name_family.text = "نام و نام خانوادگی: " + "\n"+order?.name + " " + order?.family
        phone.text = "شماره تماس: " + "\n"+order?.phone
        address.text = "آدرس: " + "\n"+order?.address
        desc.text = "توضیحات: " + "\n"+order?.description

        Glide.with(context)
            .load(order?.image_url)
            .into(cover)

    }


    override fun setViewListeners() {

        cancel_btn.setOnClickListener {
            order?.status = orderStatus.CANCELED.toString()

            MainActivity.database?.orderDao()?.update(order)

            finish()
        }

        back.setOnClickListener {
            finish()
        }
    }

    override fun setActivityContent() {
    }

    private fun orderState() = " وضعیت سفارش: " + "\n"+when (order?.status) {
        orderStatus.SUBMITTED.toString() -> {
            "ثبت شده"
        }
        orderStatus.CANCELED.toString() -> {
            "لغو شده"
        }
        orderStatus.PROCESSING.toString() -> {
            "در حال بررسی"
        }
        orderStatus.DELIVERED.toString() -> {
            "تحویل داده شده"
        }
        orderStatus.SENT.toString() -> {
            "ارسال شده"
        }
        else -> ""
    }
}