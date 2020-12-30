package info.meysam.coverto.webservice

import info.meysam.coverto.data.models.Card


class CardsResponse {

    var error: Int? = null
    var message: String? = null
    var cards: Map<String, ArrayList<Card>>? = null

}