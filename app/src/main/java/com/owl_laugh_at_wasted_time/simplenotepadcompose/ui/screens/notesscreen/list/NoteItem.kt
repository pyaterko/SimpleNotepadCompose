package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.screens.notesscreen.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.owl_laugh_at_wasted_time.simplenotepadcompose.R
import com.owl_laugh_at_wasted_time.simplenotepadcompose.domain.entity.ItemNote

@Composable
fun NoteItem(
    itemNote: ItemNote,
    onItemClickListener:(ItemNote)->Unit,
    onClickDeleteIcon: (ItemNote)->Unit
) {
    Row (
        modifier = Modifier.clickable {
            onItemClickListener.invoke(itemNote)
        }
            ){

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding( 8.dp),
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
                    text = itemNote.title,
                    color=Color.Black,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 20.sp,

                )
                IconButton(onClick = {
                    onClickDeleteIcon.invoke(itemNote)
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_delete_outline_24),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 8.dp)

                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun NoteItemPreview(){
   NoteItem(itemNote = ItemNote(
        title = "note"
    ), onItemClickListener = {},
       onClickDeleteIcon = {})
}