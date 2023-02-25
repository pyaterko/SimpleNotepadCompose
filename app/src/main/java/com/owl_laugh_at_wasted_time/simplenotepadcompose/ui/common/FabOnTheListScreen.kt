package com.owl_laugh_at_wasted_time.simplenotepadcompose.ui.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FabOnTheListScreen(state: LazyListState, modifier: Modifier, launchEvent: () -> Unit) {
    AnimatedVisibility(
        visible = state.isScrollingUp().value,
        modifier = modifier,
        enter = FabEnterAnim,
        exit = FabExitAnim,
    ) {
        FloatingActionButton(
            onClick = {
                launchEvent()
            },
            modifier = Modifier.padding(8.dp),
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Icon(Icons.Default.Add, "Add")
        }
    }
}

@Composable
private fun LazyListState.isScrollingUp(): State<Boolean> {
    return produceState(initialValue = true) {
        var lastIndex = 0
        var lastScroll = Int.MAX_VALUE
        snapshotFlow {
            firstVisibleItemIndex to firstVisibleItemScrollOffset
        }.collect { (currentIndex, currentScroll) ->
            if (currentIndex != lastIndex || currentScroll != lastScroll) {
                value = currentIndex < lastIndex ||
                        (currentIndex == lastIndex && currentScroll < lastScroll)
                lastIndex = currentIndex
                lastScroll = currentScroll
            }
        }
    }
}

private val FabEnterAnim = slideInVertically(initialOffsetY = { it })
private val FabExitAnim = slideOutVertically(targetOffsetY = { it })
