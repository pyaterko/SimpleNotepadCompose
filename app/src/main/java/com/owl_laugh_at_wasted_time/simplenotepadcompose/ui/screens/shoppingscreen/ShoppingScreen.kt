package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.common.FabOnTheListScreen
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.ShoppingScreenAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShoppingScreen(shopViewModel: ShoppingScreenViewModel) {

    val listShopState =
        shopViewModel.listState.observeAsState(ShoppingListScreenState.Initial)
    var shouldShowDialog by remember { mutableStateOf(false) }
    var productName by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.padding(bottom = 48.dp),
        topBar = {
            ShoppingScreenAppBar()
        }
    ) {
        if (shouldShowDialog) {
            AlertDialog(
                onDismissRequest = {
                    shouldShowDialog = false
                },
                title = { Text(text = "Добавить товар") },
                text = {
                    TextField(
                        value = productName,
                        onValueChange = { productName = it })
                },
                confirmButton = {
                    Button(
                        onClick = {
                            shopViewModel.add(ItemShopping(productName = productName))
                            shouldShowDialog = false
                            productName = ""
                        }
                    ) {
                        Text(
                            text = "Подтвердить!",
                            color = MaterialTheme.colors.onPrimary,
                        )
                    }
                },
            )
        }
        ShoppingList(listShopState, shopViewModel){
            shouldShowDialog = true
        }
    }
}

@Composable
private fun ShoppingList(
    listShopState: State<ShoppingListScreenState>,
    shopViewModel: ShoppingScreenViewModel,
    shouldShowDialog: () -> Unit
) {
    Surface(Modifier.fillMaxSize()) {
        val lazyState = rememberLazyListState()
    LazyColumn(
        state = lazyState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        when (val state = listShopState.value) {
            is ShoppingListScreenState.ShopList -> {
                val list = state.list
                items(list.size) { index ->
                    ShopItem(
                        itemShopping = list[index],
                        onChecked = {
                            shopViewModel.add(it)
                        },
                        onClickDeleteIcon = { shopViewModel.delete(it) }
                    )
                }
            }
            ShoppingListScreenState.Initial -> {}
        }
    }
        FabOnTheListScreen(
            lazyState,
            Modifier
                .padding(bottom = 12.dp)
                .wrapContentSize(align = Alignment.BottomEnd)
        ) {
            shouldShowDialog()
        }

    }
}

