package info.meysam.coverto.helpers

import com.appizona.yehiahd.fastsave.FastSave
import info.meysam.coverto.data.models.Card


class SharedObjects {


    companion object {

        var cards: ArrayList<Card>? = null


        fun getCardsList(): ArrayList<Card> {

            if (cards == null) {

                cards =
                    FastSave.getInstance()
                        .getObjectsList(CARDS, Card::class.java) as ArrayList<Card>

            }


            return cards!!

        }

        fun setCardsList(cards: ArrayList<Card>) {

            FastSave.getInstance().saveObjectsList(CARDS, cards)

            this.cards = cards


        }


    }
}