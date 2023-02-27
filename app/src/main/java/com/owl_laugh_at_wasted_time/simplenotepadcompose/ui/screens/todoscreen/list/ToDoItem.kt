package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.R
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo

@Composable
fun ToDoItem(
    item: ItemToDo,
    onItemClickListener: (ItemToDo) -> Unit,
) {
    Row(
        modifier = Modifier.clickable {
            onItemClickListener.invoke(item)
        }
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(
                topStart = 16.dp,
                bottomEnd = 16.dp
            ),
            elevation = 8.dp,
            border = BorderStroke(1.dp, Color.Yellow)

        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var isExpanded by remember {
                    mutableStateOf(false)
                }
                Text(
                    buildAnnotatedString {
                        if (item.data == "") {
                            append(  "${item.title}\n")
                            withStyle(SpanStyle(fontFamily = FontFamily.Cursive, fontSize = 14.sp)){
                                append(stringResource(R.string.reminder_not_set))
                            }
                        } else {
                            append(  "${item.title}\n")
                            withStyle(SpanStyle(fontFamily = FontFamily.Cursive, fontSize = 14.sp)){
                                append( "${stringResource(R.string.remind_me)} ${item.data}")
                            }
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            horizontal = 8.dp,
                            vertical = 2.dp
                        )
                        .clickable {
                            isExpanded = !isExpanded
                        },
                    maxLines = if (isExpanded) 100 else 1,
                    color = MaterialTheme.colors.onPrimary,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Preview
@Composable
fun ToDoItemPreview() {
    ToDoItem(
        item = ItemToDo(
            title = "obo"
        ),
        onItemClickListener = {})
}