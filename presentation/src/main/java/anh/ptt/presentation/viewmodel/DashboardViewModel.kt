package anh.ptt.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import anh.ptt.core.Result
import anh.ptt.domain.entities.BuyEntity
import anh.ptt.domain.entities.CallEntity
import anh.ptt.domain.entities.SellEntity
import anh.ptt.domain.usecase.dasboard.DashboardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardUseCase: DashboardUseCase
) : ViewModel() {

    private val _callList = MutableLiveData<Result<List<CallEntity>>>()
    val callList: LiveData<Result<List<CallEntity>>> get() = _callList

    private val _buyList = MutableLiveData<Result<List<BuyEntity>>>()
    val buyList: LiveData<Result<List<BuyEntity>>> get() = _buyList

    private val _sellList = MutableLiveData<Result<List<SellEntity>>>()
    val sellList: LiveData<Result<List<SellEntity>>> get() = _sellList

    fun getCallList() = viewModelScope.launch(Dispatchers.IO) {
        val result = dashboardUseCase.callListExecute()
        withContext(Dispatchers.Main) {
            _callList.value = result
        }
    }

    fun getBuyList() = viewModelScope.launch(Dispatchers.IO) {
        val result = dashboardUseCase.buyListExecute()
        withContext(Dispatchers.Main) {
            _buyList.value = result
        }
    }

    fun getSellList() = viewModelScope.launch(Dispatchers.IO) {
        val result = dashboardUseCase.sellListExecute()
        withContext(Dispatchers.Main) {
            _sellList.value = result
        }
    }

}