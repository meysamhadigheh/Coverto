package info.meysam.coverto.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import hivatec.ir.hivatectools.adapters.HivaRecyclerAdapter
import hivatec.ir.hivatectools.adapters.OnItemClickListener
import info.meysam.coverto.R
import info.meysam.coverto.data.models.Card
import info.meysam.coverto.data.models.Order
import info.meysam.coverto.helpers.*
import info.meysam.coverto.ui.activities.MainActivity
import info.meysam.coverto.ui.activities.TypeChooseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {


    val adapter = HivaRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        container.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        adapter.items = SharedObjects.getCardsList()
        container?.adapter = adapter


        adapter.setOnItemClickListener(Card::class.java) { item, _ ->

            var order = Order()
            order.code = item.id.toString()
            order.image_url = item.image
            val intent = Intent(context, TypeChooseActivity::class.java)
            intent.putExtra(ORDERINFO, Gson().toJson(order))
            startActivityForResult(intent, ORDERSUBMITTED)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == ORDERSUBMITTED) {

            (activity as MainActivity).bottom_navigation.currentItem = ORDERSBNAV

        }
    }

}