package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.todoscreen.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemToDo
import com.owl_laugh_at_wasted_time.simplenotepadcompose.navigation.rememberNavigationState

@Composable
fun ToDoItem(
    item: ItemToDo,
    onItemClickListener: (ItemToDo) -> Unit,
) {
    val toDoItem = item
    Row(
        modifier = Modifier.clickable {
            onItemClickListener.invoke(toDoItem)
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
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

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    text = toDoItem.title,
                    color = Color.Black,
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
    val navigationState = rememberNavigationState()
    ToDoItem(
        item = ItemToDo(
            title = "obo"
        ),
        onItemClickListener = {})
}