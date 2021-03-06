package info.meysam.coverto.helpers


const val CARDS: String = "CARDS"
const val ORDERINFO: String = "ORDERINFO"
const val CARDINFO: String = "CARDINFO"


const val NAME: String = "NAME"
const val FAMILY: String = "FAMILY"
const val PHONE: String = "PHONE"
const val ADDRESS: String = "ADDRESS"




/**
 * bottom navigation item
 */
const val HOMEBNAV = 2
const val ORDERSBNAV = 1
const val PROFILEBNAV = 0


const val ORDERSUBMITTED: Int = 9999



enum class orderStatus {

    SUBMITTED,
    PROCESSING,
    SENT,
    DELIVERED,
    CANCELED
}

enum class caseType {

    TWO_D,
    THREE_D

}





