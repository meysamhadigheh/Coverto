package info.meysam.coverto.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import info.meysam.coverto.R
import info.meysam.coverto.helpers.SharedObjects
import kotlinx.android.synthetic.main.fragment_profile.*


/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        submit.setOnClickListener {

            SharedObjects.setName_t(edt_name.text.toString())
            SharedObjects.setFamily_t(edt_family.text.toString())
            SharedObjects.setPhone_t(edt_mobile.text.toString())
            SharedObjects.setAddress_t(edt_address.text.toString())

            Snackbar.make(layout_profile, "تغییرات با موفقیت ثبت گردید.", Snackbar.LENGTH_SHORT)
                .show()


        }

    }

    override fun onResume() {
        super.onResume()

        edt_name.setText(SharedObjects.getName_t())
        edt_family.setText(SharedObjects.getFamily_t())
        edt_mobile.setText(SharedObjects.getPhone_t())
        edt_address.setText(SharedObjects.getAddress_t())


    }


}