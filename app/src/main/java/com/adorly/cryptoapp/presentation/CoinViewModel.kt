package com.adorly.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.adorly.cryptoapp.data.database.CoinInfoDbModel
import com.adorly.cryptoapp.data.repository.CoinRepositoryImpl
import com.adorly.cryptoapp.domain.GetCoinInfoListUseCase
import com.adorly.cryptoapp.domain.GetCoinInfoUseCase
import com.adorly.cryptoapp.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    init{
        viewModelScope.launch {
            loadDataUseCase()
        }

    }

    fun getDetailInfo(fSym:String) = getCoinInfoUseCase(fSym)


}


