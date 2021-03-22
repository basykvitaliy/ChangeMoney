package space.basyk.changemoney.data.api

import retrofit2.Response
import retrofit2.http.GET
import space.basyk.changemoney.model.beznal.BeznalModel
import space.basyk.changemoney.model.nal.PrivatMoney

interface ApiService {

    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getCurrentMoneys(): Response<PrivatMoney>

    @GET("p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getbeznalMoneys(): Response<BeznalModel>
}