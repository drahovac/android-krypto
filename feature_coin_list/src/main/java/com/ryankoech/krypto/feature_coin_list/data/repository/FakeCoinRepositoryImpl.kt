package com.ryankoech.krypto.feature_coin_list.data.repository

import com.ryankoech.krypto.common.presentation.util.DisplayCurrency
import com.ryankoech.krypto.feature_coin_list.data.dto.CoinDto
import com.ryankoech.krypto.feature_coin_list.data.dto.CoinLocalDto
import com.ryankoech.krypto.feature_coin_list.data.dto.Roi
import com.ryankoech.krypto.feature_coin_list.data.dto.display_currency.DisplayCurrencyDto
import com.ryankoech.krypto.feature_coin_list.data.dto.toLocalCoinDto
import com.ryankoech.krypto.feature_coin_list.domain.repository.CoinRepository
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

val FAKE_COIN_LIST = listOf(
    CoinDto(
        id = "bitcoin",
        symbol = "btc",
        name = "Bitcoin",
        image = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579",
        current_price = 16923.04,
        market_cap = 325934668465,
        market_cap_rank = 1,
        fully_diluted_valuation = 355472891513,
        total_volume = 17324993150.0,
        high_24h = 17021.29,
        low_24h = 16710.14,
        price_change_24h = 154.92,
        price_change_percentage_24h = 0.92388,
        market_cap_change_24h = 2557781776.0,
        market_cap_change_percentage_24h = 0.79096,
        circulating_supply = 19254993.0,
        total_supply = 21000000.0,
        max_supply = 21000000.0,
        ath = 69045.0,
        ath_change_percentage = -75.48315,
        ath_date = "2021-11-10T14:24:11.849Z",
        atl = 67.81,
        atl_change_percentage = 24863.64704,
        atl_date = "2013-07-06T00:00:00.000Z",
        roi = null,
        last_updated = "2023-01-07T10:58:06.894Z",
    ),
    CoinDto(
        id = "ethereum",
        symbol = "eth",
        name = "Ethereum",
        image = "https://assets.coingecko.com/coins/images/279/large/ethereum.png?1595348880",
        current_price = 1264.4,
        market_cap = 152465403313,
        market_cap_rank = 2,
        fully_diluted_valuation = 152465403313,
        total_volume = 4738147647.0,
        high_24h = 1275.78,
        low_24h = 1242.1,
        price_change_24h = 18.52,
        price_change_percentage_24h = 1.48649,
        market_cap_change_24h = 2033182578.0,
        market_cap_change_percentage_24h = 1.35156,
        circulating_supply = 120524497.701488,
        total_supply = 120524497.701488,
        max_supply = null,
        ath = 4878.26,
        ath_change_percentage = -74.06476,
        ath_date = "2021-11-10T14:24:19.604Z",
        atl = 0.432979,
        atl_change_percentage = 292105.57124,
        atl_date = "2015-10-20T00:00:00.000Z",
        roi = Roi(
            times = 98.89428081326518,
            currency = "btc",
            percentage = 9889.428081326518,
        ),
        last_updated = "2023-01-07T10:58:08.421Z",
    ),
    CoinDto(
        id = "tether",
        symbol = "usdt",
        name = "Tether",
        image = "https://assets.coingecko.com/coins/images/325/large/Tether.png?1668148663",
        current_price = 1.0,
        market_cap = 66308002007,
        market_cap_rank = 3,
        fully_diluted_valuation = 66308002007,
        total_volume = 22830407217.0,
        high_24h = 1.002,
        low_24h = 0.997607,
        price_change_24h = -0.000014506074960785,
        price_change_percentage_24h = -0.00145,
        market_cap_change_24h = 26631461.0,
        market_cap_change_percentage_24h = 0.04018,
        circulating_supply = 66272490385.2966,
        total_supply = 66272490385.2966,
        max_supply = null,
        ath = 1.32,
        ath_change_percentage = -24.38936,
        ath_date = "2018-07-24T00:00:00.000Z",
        atl = 0.572521,
        atl_change_percentage = 74.73609,
        atl_date = "2015-03-02T00:00:00.000Z",
        roi = null,
        last_updated = "2023-01-07T10:55:07.354Z",
    ),
    CoinDto(
        id = "usd-coin",
        symbol = "usdc",
        name = "USD Coin",
        image = "https://assets.coingecko.com/coins/images/6319/large/USD_Coin_icon.png?1547042389",
        current_price = 1.0,
        market_cap = 43793762275,
        market_cap_rank = 4,
        fully_diluted_valuation = 43790483878,
        total_volume = 2138738912.0,
        high_24h = 1.002,
        low_24h = 0.997155,
        price_change_24h = 0.00025959,
        price_change_percentage_24h = 0.02596,
        market_cap_change_24h = -67821872.7326355,
        market_cap_change_percentage_24h = -0.15463,
        circulating_supply = 43775348278.3757,
        total_supply = 43772071259.4457,
        max_supply = null,
        ath = 1.17,
        ath_change_percentage = -14.7167,
        ath_date = "2019-05-08T00:40:28.300Z",
        atl = 0.891848,
        atl_change_percentage = 12.14047,
        atl_date = "2021-05-19T13:14:05.611Z",
        roi = null,
        last_updated = "2023-01-07T10:58:02.371Z",
    ),
    CoinDto(
        id = "binancecoin",
        symbol = "bnb",
        name = "BNB",
        image = "https://assets.coingecko.com/coins/images/825/large/bnb-icon2_2x.png?1644979850",
        current_price = 261.01,
        market_cap = 42629851070,
        market_cap_rank = 5,
        fully_diluted_valuation = 52217835573,
        total_volume = 429267785.0,
        high_24h = 262.55,
        low_24h = 255.42,
        price_change_24h = 4.84,
        price_change_percentage_24h = 1.88825,
        market_cap_change_24h = 737476415.0,
        market_cap_change_percentage_24h = 1.76041,
        circulating_supply = 163276974.63,
        total_supply = 163276974.63,
        max_supply = 200000000.0,
        ath = 686.31,
        ath_change_percentage = -61.94239,
        ath_date = "2021-05-10T07:24:17.097Z",
        atl = 0.0398177,
        atl_change_percentage = 655869.36318,
        atl_date = "2017-10-19T00:00:00.000Z",
        roi = null,
        last_updated = "2023-01-07T10:58:10.067Z",
    ),
    CoinDto(
        id = "ripple",
        symbol = "xrp",
        name = "XRP",
        image = "https://assets.coingecko.com/coins/images/44/large/xrp-symbol-white-128.png?1605778731",
        current_price = 0.343551,
        market_cap = 17368882302,
        market_cap_rank = 6,
        fully_diluted_valuation = 34350451021,
        total_volume = 575571042.0,
        high_24h = 0.346053,
        low_24h = 0.334424,
        price_change_24h = 0.00761656,
        price_change_percentage_24h = 2.26727,
        market_cap_change_24h = 346730797.0,
        market_cap_change_percentage_24h = 2.03694,
        circulating_supply = 50563767827.0,
        total_supply = 99989171756.0,
        max_supply = 100000000000.0,
        ath = 3.4,
        ath_change_percentage = -89.89294,
        ath_date = "2018-01-07T00:00:00.000Z",
        atl = 0.00268621,
        atl_change_percentage = 12686.92874,
        atl_date = "2014-05-22T00:00:00.000Z",
        roi = null,
        last_updated = "2023-01-07T10:58:10.468Z",
    ),
    CoinDto(
        id = "binance-usd",
        symbol = "busd",
        name = "Binance USD",
        image = "https://assets.coingecko.com/coins/images/9576/large/BUSD.png?1568947766",
        current_price = 1.001,
        market_cap = 16437019062,
        market_cap_rank = 7,
        fully_diluted_valuation = 16437019062,
        total_volume = 5323587945.0,
        high_24h = 1.004,
        low_24h = 0.999316,
        price_change_24h = 0.00102026,
        price_change_percentage_24h = 0.10205,
        market_cap_change_24h = -255937616.80016136,
        market_cap_change_percentage_24h = -1.53321,
        circulating_supply = 16424967238.39,
        total_supply = 16424967238.39,
        max_supply = null,
        ath = 1.15,
        ath_change_percentage = -13.3031,
        ath_date = "2020-03-13T02:35:42.953Z",
        atl = 0.901127,
        atl_change_percentage = 11.04527,
        atl_date = "2021-05-19T13:04:37.445Z",
        roi = null,
        last_updated = "2023-01-07T10:57:59.111Z",
    )
)

val FakeDisplayCurrencies = listOf(
    DisplayCurrencyDto(DisplayCurrency.BNB, 262.4234),
    DisplayCurrencyDto(DisplayCurrency.USD, 1.0),
    DisplayCurrencyDto(DisplayCurrency.ETH, 1274.1234),
    DisplayCurrencyDto(DisplayCurrency.BTC, 17505.54256),
    DisplayCurrencyDto(DisplayCurrency.LTC, 74.13),
).sortedBy { it.currency.ordinal }


class FakeCoinRepositoryImpl @Inject constructor() : CoinRepository {
    override suspend fun getCoins(): Response<List<CoinDto>> {
        return Response.success(FAKE_COIN_LIST)
    }

    override suspend fun getLocalCoins(): List<CoinLocalDto> = FAKE_COIN_LIST.toLocalCoinDto()

    override suspend fun saveCoins(coins: List<CoinLocalDto>) {
        Timber.d("Saved Coins Successfully")
    }

    override suspend fun getCoin(coinId: String): CoinLocalDto = FAKE_COIN_LIST.toLocalCoinDto().first()

    override suspend fun saveDisplayCurrencyData(displayCurrencyDataMap: HashMap<DisplayCurrency, Double>) {
        Timber.d("Saved Local DisplayCurrency Data")
    }

    override suspend fun getDisplayCurrencyData(): List<DisplayCurrencyDto>?{
        return FakeDisplayCurrencies
    }
}