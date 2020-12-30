package info.meysam.coverto.data.models

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import hivatec.ir.hivatectools.adapters.ItemBinder
import hivatec.ir.hivatectools.adapters.ItemHolder
import info.meysam.coverto.R
import kotlinx.android.synthetic.main.item_card.view.*


class Card : ItemBinder {

    var image: String? = null
    var id: Int? = null
    var title: String? = null

    override fun bindToHolder(binder: ItemHolder?, listener: Any?) {

        val requestOptions = RequestOptions()
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)

        Glide.with( binder?.context!! )
            .load( image ).apply(requestOptions)
            .into(binder.itemView.image )

        binder.itemView.title.text = title


    }

    override fun getResourceId(): Int {

        return R.layout.item_card
    }


}