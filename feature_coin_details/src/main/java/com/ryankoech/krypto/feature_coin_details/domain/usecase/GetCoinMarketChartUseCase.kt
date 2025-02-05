package com.ryankoech.krypto.feature_coin_details.domain.usecase

import com.ryankoech.krypto.common.core.util.Resource
import com.ryankoech.krypto.feature_coin_details.core.di.HILT_NAME_REPO_FOR_ALL
import com.ryankoech.krypto.feature_coin_details.data.dto.market_chart_dto.toMarketChartEntityList
import com.ryankoech.krypto.feature_coin_details.domain.entity.MarketChartEntity
import com.ryankoech.krypto.feature_coin_details.domain.repository.CoinDetailsRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import timber.log.Timber
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class GetCoinMarketChartUseCase @Inject constructor(
    @Named(HILT_NAME_REPO_FOR_ALL) private val repository: CoinDetailsRepository
) {
    operator fun invoke(coinId : String) = flow<Resource<List<List<MarketChartEntity>>>> {

        val dayMarketChartResponse = repository.getDayMarketChart(coinId)
        val threeMonthMarketChartResponse = repository.getThreeMonthsMarketChart(coinId)
        val yearMarketChartResponse = repository.getYearMarketChart(coinId)

        if(dayMarketChartResponse.isSuccessful && threeMonthMarketChartResponse.isSuccessful && yearMarketChartResponse.isSuccessful) {

            emit(Resource.Success(listOf(
                dayMarketChartResponse.body()!!.toMarketChartEntityList(),
                threeMonthMarketChartResponse.body()!!.toMarketChartEntityList(),
                yearMarketChartResponse.body()!!.toMarketChartEntityList(),
            )))

        } else {
            throw Exception("Response not Successful.")
        }

    }.onStart {
        emit(Resource.Loading())
    }.catch { e ->
        Timber.e(e)
        emit(Resource.Error( e.localizedMessage ?: "Unexpected Error Occurred."))
    }

}