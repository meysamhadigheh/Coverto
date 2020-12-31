package info.meysam.coverto.data.models

import android.annotation.SuppressLint
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import hivatec.ir.hivatectools.adapters.ItemBinder
import hivatec.ir.hivatectools.adapters.ItemHolder
import info.meysam.coverto.R
import info.meysam.coverto.helpers.caseType
import info.meysam.coverto.helpers.orderStatus
import kotlinx.android.synthetic.main.item_order.view.*

@Entity(tableName = "orders")
class Order : ItemBinder {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "family")
    var family: String? = null

    @ColumnInfo(name = "code")
    var code: String? = null

    @ColumnInfo(name = "address")
    var address: String? = null

    @ColumnInfo(name = "date")
    var date: String? = PersianCalendar(System.currentTimeMillis()).persianLongDate

    @ColumnInfo(name = "c_type")
    var c_type: String? = caseType.TWO_D.toString()

    @ColumnInfo(name = "phone")
    var phone: String? = null

    @ColumnInfo(name = "description")
    var description: String? = null

    @ColumnInfo(name = "image_url")
    var image_url: String? = null


    @ColumnInfo(name = "status")
    var status: String? = orderStatus.SUBMITTED.toString()
    override fun getResourceId(): Int {

        return R.layout.item_order
    }

    @SuppressLint("SetTextI18n")
    override fun bindToHolder(binder: ItemHolder?, listener: Any?) {
        binder?.itemView?.order_id?.text = " کد سفارش: $id"
        binder?.itemView?.order_code?.text = " شماره طرح: ${code.toString()}"

        binder?.itemView?.order_status?.text = " وضعیت سفارش: " + when (status) {
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
}