package com.adorly.cryptoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.adorly.cryptoapp.adapters.CoinInfoAdapter
import com.adorly.cryptoapp.pojo.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPiceInfo: CoinPriceInfo) {
                Log.d("ON_CLICK_TEST", coinPiceInfo.fromsymbol )
            }
        }
        val rvCoinPriceList = findViewById<RecyclerView>(R.id.rvCoinPriceList)
        rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })
//    viewModel.getDetailInfo("BTC").observe(this, Observer{ Log.d("TEST_OF_LOADING_DATA", "Success $it" )})

    }

}