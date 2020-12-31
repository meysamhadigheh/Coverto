package info.meysam.coverto.helpers

import com.appizona.yehiahd.fastsave.FastSave
import info.meysam.coverto.data.models.Card


class SharedObjects {



    companion object {

        var cards: ArrayList<Card>? = null
        var name: String? = null
        var family: String? = null
        var phone: String? = null
        var address: String? = null

        fun getName_t(): String? {
            if (name == null) {
                name =
                    FastSave.getInstance()
                        .getString(NAME)
            }
            return name
        }

        fun setName_t(name: String) {

            FastSave.getInstance().saveString(NAME, "")
            this.name = name


        }

        fun getFamily_t(): String? {
            if (family == null) {
                family =
                    FastSave.getInstance()
                        .getString(FAMILY)
            }
            return family
        }

        fun setFamily_t(family: String) {

            FastSave.getInstance().saveString(FAMILY, "")
            this.family = family


        }

        fun getPhone_t(): String? {
            if (phone == null) {
                phone =
                    FastSave.getInstance()
                        .getString(PHONE)
            }
            return phone
        }

        fun setPhone_t(phone: String) {

            FastSave.getInstance().saveString(PHONE, "")
            this.phone = phone


        }

        fun getAddress_t(): String? {
            if (address == null) {
                address =
                    FastSave.getInstance()
                        .getString(ADDRESS)
            }
            return address
        }

        fun setAddress_t(address: String) {

            FastSave.getInstance().saveString(ADDRESS, "")
            this.address = address


        }


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