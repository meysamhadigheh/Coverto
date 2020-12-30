package info.meysam.coverto.ui.activities

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import info.meysam.coverto.R
import info.meysam.coverto.helpers.HOMEBNAV
import info.meysam.coverto.ui.fragments.HomeFragment
import info.meysam.coverto.ui.fragments.OrdersFragment
import info.meysam.coverto.ui.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    var home: Boolean = false

    private var homeFragment: HomeFragment? = null
    private var ordersFragment: OrdersFragment? = null
    private var profileFragment: ProfileFragment? = null

    private var currentFragment: Fragment? = null


    override fun setContentViewActivity() {

        setContentView(R.layout.activity_main)

    }

    override fun getIntentData() {
    }

    override fun instantiateViews() {

        bottom_navigation.labelVisibilityMode =
            LabelVisibilityMode.LABEL_VISIBILITY_LABELED // for enableShiftingMode(false)
        bottom_navigation.isItemHorizontalTranslationEnabled =
            false // for enableItemShiftingMode(false)
        bottom_navigation.enableAnimation(false)

        val typeface = Typeface.createFromAsset(context.assets, "fonts/irfontnumlight.ttf")
        bottom_navigation.setTypeface(typeface)

        bottom_navigation.setTextSize(10f)
    }

    override fun setViewListeners() {

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            menuSelector(item.itemId)
            true
        }
    }

    override fun setActivityContent() {

        bottom_navigation.currentItem = HOMEBNAV

    }

    private fun menuSelector(item: Int) {

        when (item) {
            R.id.i_home -> {

                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                }


                home = true


                loadFragment(homeFragment!!, "h")


            }
            R.id.i_orders -> {

                if (ordersFragment == null) {
                    ordersFragment = OrdersFragment()
                }


                home = false
                loadFragment(ordersFragment!!, "o")


            }
            R.id.i_profile -> {

                if (profileFragment == null) {
                    profileFragment = ProfileFragment()
                }


                home = false

                loadFragment(profileFragment!!, "p")

            }

        }

    }


    private fun loadFragment(fragment: Fragment, tag: String) {

        val t = supportFragmentManager.beginTransaction()

        if (currentFragment != null) {
            t.detach(currentFragment!!)
        }

        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            t.add(R.id.frame_container, fragment, tag)
        } else {
            t.attach(fragment)
        }

        t.commit()

        currentFragment = fragment
    }


    override fun onBackPressed() {

        if (home) {

            finish()

        } else {

            bottom_navigation.currentItem = HOMEBNAV

        }
    }
}


