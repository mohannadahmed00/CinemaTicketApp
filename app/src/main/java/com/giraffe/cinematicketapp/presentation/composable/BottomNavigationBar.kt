package com.giraffe.cinematicketapp.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.giraffe.cinematicketapp.presentation.screen.home.Tab

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedTab: Tab,
    iconSize: Dp = 48.dp,
    selectTab: (Tab) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Tab.entries.forEach {
            TabIcon(
                modifier = Modifier.clickable(
                    interactionSource = null,
                    indication = null
                ) {
                    selectTab(it)
                },
                icon = it.icon,
                notificationCount = it.notificationCount,
                isSelected = it == selectedTab,
                iconSize = iconSize
            )
        }
    }
}