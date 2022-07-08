package com.noobdev.propermvvmarcitecture.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noobdev.propermvvmarcitecture.domain.model.DataItem

@Composable
fun MainComposeFragment(title: String, dataItemList: List<DataItem>) {
    val (value, updateValue) = remember { mutableStateOf("") }
    //get context
    Column(
        modifier = Modifier
            .padding(0.dp, 50.dp, 0.dp, 0.dp)
            .fillMaxSize()
            .background(color = Color.LightGray),
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .background(color = Color.Black),
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(2.dp),
            value = value,
            onValueChange = { newValue -> updateValue.invoke(newValue) }
        )

        ListItem("#", "Name", "24h", "Price")

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
//                items(3) { v: Int ->
//                    ListItem(v.toString(), "Name", "24h", "Price")
//                }
            items(dataItemList.size) { d: Int ->
                ListItem(
                    (d + 1).toString(),
                    dataItemList[d].name.toString(),
                    dataItemList[d].changePercent24Hr.toString(),
                    dataItemList[d].priceUsd.toString()
                )
            }
        }
    }
}


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