package info.meysam.coverto.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import hivatec.ir.hivatectools.adapters.HivaRecyclerAdapter
import info.meysam.coverto.R
import info.meysam.coverto.data.models.Order
import info.meysam.coverto.helpers.ORDERINFO
import info.meysam.coverto.ui.activities.MainActivity
import info.meysam.coverto.ui.activities.OrderDetailsActivity
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 * Use the [OrdersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrdersFragment : Fragment() {


    val adapter = HivaRecyclerAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        container.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        container?.adapter = adapter


        adapter.setOnItemClickListener(Order::class.java) { item, _ ->
            val intent = Intent(context, OrderDetailsActivity::class.java)
            intent.putExtra(ORDERINFO, Gson().toJson(item))
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()

        var notes: List<Order> = ArrayList()
        notes = MainActivity.database?.orderDao()?.getAll()!! as ArrayList

        adapter.items = notes
        adapter.notifyDataSetChanged()


    }


}