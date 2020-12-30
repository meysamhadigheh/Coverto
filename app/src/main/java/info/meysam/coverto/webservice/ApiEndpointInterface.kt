package info.meysam.coverto.webservice

import info.meysam.coverto.webservice.CardsResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiEndpointInterface {
    // Request method and URL specified in the annotation


    @GET("cards.json")
    fun allCards(
    ): Call<CardsResponse>


}