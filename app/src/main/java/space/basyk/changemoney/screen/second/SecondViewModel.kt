package space.basyk.changemoney.screen.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import space.basyk.changemoney.model.beznal.BeznalModel
import space.basyk.changemoney.model.nal.PrivatMoney
import space.basyk.changemoney.utils.REPOSITORY

class SecondViewModel: ViewModel() {
    val myPrivat: MutableLiveData<BeznalModel> = MutableLiveData()

    fun getPrivatMoney(){
        viewModelScope.launch {
            myPrivat.value = REPOSITORY.getBeznalMoney().body()
        }

    }
}