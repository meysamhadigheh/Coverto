package info.meysam.coverto.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.meysam.coverto.R

/**
 * A simple [Fragment] subclass.
 * Use the [OrdersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrdersFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }



}