package info.meysam.coverto.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import info.meysam.coverto.data.models.Order

@Dao
interface OrderDao {


    @Insert
    fun insert(order: Order)

    @Update
    fun update(order: Order)


    @get:Query("SELECT * FROM orders")
    val all: ArrayList<Order?>?


    @Query("DELETE FROM orders WHERE id = :id")
    fun delete(id: Int)
}