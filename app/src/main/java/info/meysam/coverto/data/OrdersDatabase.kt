package info.meysam.coverto.data

import androidx.room.Database
import androidx.room.RoomDatabase
import info.meysam.coverto.data.models.Order

@Database(entities = [Order::class], version = 4)
abstract class OrdersDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao2?
}