package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.shoppingscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.owl_laugh_at_wasted_time.simplenotepadcompose.R
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemShopping
import com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.theme.SimpleNotepadComposeTheme
import com.owl_laugh_at_wasted_time.simplenotepadcompose.until.MyCheckBoxColors

@Composable
fun ShopItem(
    itemShopping: ItemShopping,
    onChecked: (ItemShopping) -> Unit,
    onClickDeleteIcon: (ItemShopping) -> Unit,
) {
    Row {
        val matrix = ColorMatrix()
        matrix.setToSaturation(0.3F)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://loremflickr.com/320/240/${itemShopping.productName}")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(matrix)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            shape = RoundedCornerShape(
                topStart = 18.dp,
                bottomEnd = 18.dp
            ),
            elevation = 8.dp,
            border = BorderStroke(1.dp, Color.Yellow)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var checked by remember {
                    mutableStateOf(itemShopping.done)
                }
                Checkbox(
                    checked = checked,
                    colors = MyCheckBoxColors(),
                    onCheckedChange = {
                        checked = !checked
                        onChecked.invoke(itemShopping.copy(done = checked))
                    }
                )
                val textDecoration = if (checked) {
                    TextDecoration.LineThrough
                } else {
                    TextDecoration.None
                }
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 2.dp),
                    text = itemShopping.productName,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 20.sp,
                    textDecoration = textDecoration
                )
                IconButton(onClick = {
                    onClickDeleteIcon.invoke(itemShopping)
                }) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_delete_outline_24),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 8.dp
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ShopItemPreview() {
    SimpleNotepadComposeTheme {
        ShopItem(ItemShopping(), {}) {}
    }
}