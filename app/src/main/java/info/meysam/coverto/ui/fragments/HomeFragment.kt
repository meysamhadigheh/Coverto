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
import info.meysam.coverto.helpers.SharedObjects
import info.meysam.coverto.ui.activities.TypeChooseActivity
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

        container.layoutManager = GridLayoutManager(context,2, RecyclerView.VERTICAL, false)
        adapter.items = SharedObjects.getCardsList()
        container?.adapter = adapter


        adapter.setOnItemClickListener(Card::class.java) { item, _ ->
            val intent = Intent(context, TypeChooseActivity::class.java)
            intent.putExtra("cardInfo", Gson().toJson(item))
            startActivity(intent)
        }


    }

}