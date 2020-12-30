package info.meysam.coverto.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import info.meysam.coverto.data.models.Order;

@Dao
public interface OrderDao {

    @Query("SELECT * FROM orders")
    List<Order> getAll();

    @Insert
    void insert(Order order);

    @Update
    void update(Order order);





}