package info.meysam.coverto.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import info.meysam.coverto.data.models.Order

@Dao
interface OrderDao2 {
    /* @get:Query("SELECT * FROM orders")
    val all: List<Order>*/

    @Query("SELECT * FROM orders")
    fun getAll(): List<Order>

    @Insert
    fun insert(order: Order?)

    @Update
    fun update(order: Order?)
}