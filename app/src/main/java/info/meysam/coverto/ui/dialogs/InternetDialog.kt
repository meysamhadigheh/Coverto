package info.meysam.coverto.ui.dialogs


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import info.meysam.coverto.R

import kotlinx.android.synthetic.main.dialog_internet.*


/**
 * A simple [Fragment] subclass.
 */
class InternetDialog : DialogFragment() {


    var listener: ClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_internet, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        exit.setOnClickListener {


            (listener as ClickListener).internetExitClicked()
            dismiss()


        }

        retry_btn.setOnClickListener {

            (listener as ClickListener).internetRetryClicked()
            dismiss()


        }


    }

    interface ClickListener {

        fun internetExitClicked()
        fun internetRetryClicked()
    }

}
