package com.ryankoech.krypto.feature_home.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.ryankoech.krypto.common.presentation.theme.KryptoTheme
import com.ryankoech.krypto.feature_home.data.dto.display_currency.DisplayCurrencyDto
import com.ryankoech.krypto.feature_home.data.dto.owned_coin.OwnedCoinDto
import com.ryankoech.krypto.feature_home.data.repository.FakeDisplayCurrencies
import com.ryankoech.krypto.feature_home.data.repository.FakeOwnedCoins
import com.ryankoech.krypto.feature_home.presentation.components.success.*

const val TEST_TAG_HOME_SCREEN_SUCCESS = "test_tag_home_screen_success"

@Composable
fun HomeScreenSuccess(
    ownedCoins : List<OwnedCoinDto>,
    displayCurrencies : List<DisplayCurrencyDto>,
    onTransferInClick : () -> Unit,
    onTransferOutClick : () -> Unit,
    onWipeWalletClick : () -> Unit,
    modifier: Modifier = Modifier
) {

    if(ownedCoins.isEmpty()){
        HomeScreenSuccessNoData(
            modifier.testTag(TEST_TAG_HOME_SCREEN_SUCCESS_NO_DATA)
        )
    }else{
        HomeScreenSuccessWithData(
            ownedCoins = ownedCoins,
            displayCurrencies = displayCurrencies,
            onTransferInClick = onTransferInClick,
            onTransferOutClick = onTransferOutClick,
            onWipeWalletClick = onWipeWalletClick,
            modifier = modifier.testTag(TEST_TAG_HOME_SCREEN_SUCCESS_WITH_DATA)
        )
    }

}

@Preview
@Composable
fun HomeScreenSuccessPreview() {

    KryptoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {

            HomeScreenSuccess(FakeOwnedCoins, FakeDisplayCurrencies, {}, {}, {})

        }
    }

}