package com.noobdev.propermvvmarcitecture.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun ListItem(
    index: String,
    name: String,
    hike_24: String,
    price: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(4.dp, 4.dp)
    ) {
        Text(modifier = Modifier
            .padding(4.dp,0.dp),
            text = index
        )
        Text(text = name)
        Spacer(modifier = Modifier.weight(2f))
        Text(text = hike_24)
        Spacer(modifier = Modifier.weight(1f))

        Text(text = price,
            modifier = Modifier.padding(0.dp,0.dp,0.dp,0.dp)
        )
    }
}