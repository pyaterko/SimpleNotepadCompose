package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.mainscreen.ShoppingScreenAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShoppingScreen(shopViewModel: ShoppingScreenViewModel) {

    val listShop =
        shopViewModel.listItemShopping.observeAsState(emptyList())
    var shouldShowDialog by remember { mutableStateOf(false) }
    var productName by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.padding(bottom = 48.dp),
        topBar = {
            ShoppingScreenAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    shouldShowDialog = true
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
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
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 38.dp,
                    start = 8.dp,
                    end = 8.dp
                )
        ) {
            items(listShop.value.size) { item ->
                ShopItem(
                    itemShopping = listShop.value[item],
                    onChecked = { shopViewModel.add(it.copy(done = !it.done)) },
                    onClickDeleteIcon = { shopViewModel.delete(it) }
                )
            }
        }
    }
}

