package info.meysam.coverto.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import info.meysam.coverto.helpers.orderStatus

@Entity(tableName = "orders")
class Order {

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
    var date: String? = null

    @ColumnInfo(name = "status")
    var status: orderStatus? = null
}