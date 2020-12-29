package info.meysam.coverto.ui.activities

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Typeface
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.multidex.MultiDex
import com.appizona.yehiahd.fastsave.FastSave

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


abstract class BaseActivity : AppCompatActivity() {

    lateinit var context: Activity


    val args = Bundle()

    private val parentJob = Job()
    internal val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this


        FastSave.init(applicationContext)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)


        //set what horizontal_item to show
        setContentViewActivity()

        //if activity has any intent data
        getIntentData()

        //set custom settings for toolbar if needed
        //setToolbar();

        //instantiate and customise toolbar view
        //prepareToolbar();

        //get all views in activity content
        instantiateViews()

        //set listeners for what views should do
        setViewListeners()


        //set views content (this makes sure all views are instantiated)
        setActivityContent()


    }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }


    /**
     * dont use setContentView in onCreate
     * use this method instead
     */
    protected abstract fun setContentViewActivity()

    protected abstract fun getIntentData()

    /**
     * set custom toolbar with id 'toolbar'
     * set toolbarResource if you want to change its id
     */


    protected abstract fun instantiateViews()

    protected abstract fun setViewListeners()

    protected abstract fun setActivityContent()


    /*********
     * gets a single skeleton databaseOpenHelper to work with in activity
     *
     * @return
     */


    //*********
    //easier stuff
    //********
    protected fun showToast(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }

    protected fun showToastLong(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_LONG).show()
    }


    //*******************
    //get resources easier
    //*******************
    protected fun getColorRes(color: Int): Int {
        return resources.getColor(color)
    }


    override fun onDestroy() {

        super.onDestroy()
        parentJob.cancel()

    }


}