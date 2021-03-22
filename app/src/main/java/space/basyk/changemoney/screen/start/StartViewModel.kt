package space.basyk.changemoney.screen.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import space.basyk.changemoney.model.nal.PrivatMoney
import space.basyk.changemoney.utils.REPOSITORY

class StartViewModel: ViewModel() {

    val myMoney: MutableLiveData<Response<PrivatMoney>> = MutableLiveData()

    fun getCurrentMon(){
        viewModelScope.launch {
            myMoney.value = REPOSITORY.getCurrentMoney()
        }
    }
}