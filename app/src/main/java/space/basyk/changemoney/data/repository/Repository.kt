package space.basyk.changemoney.data.repository

import retrofit2.Response
import space.basyk.changemoney.data.api.RetrofitInstance
import space.basyk.changemoney.model.beznal.BeznalModel
import space.basyk.changemoney.model.nal.PrivatMoney

class Repository {
    suspend fun getCurrentMoney(): Response<PrivatMoney>{
        return RetrofitInstance.api.getCurrentMoneys()
    }

    suspend fun getBeznalMoney(): Response<BeznalModel>{
        return RetrofitInstance.api.getbeznalMoneys()
    }
}