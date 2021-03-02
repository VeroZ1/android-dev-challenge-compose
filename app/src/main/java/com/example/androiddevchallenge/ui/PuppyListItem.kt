package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.DemoDataProvider
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyListItem(puppy: Puppy, onClick: (position: Int, puppy: Puppy) -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp, 8.dp, 16.dp, 8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable { onClick.invoke(puppy.id, puppy) },
        shape = RoundedCornerShape(4.dp)

    ) {
        Image(
            painter = painterResource(id = puppy.images[0]),
            contentDescription = puppy.name,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Surface(
                color = Color.Unspecified,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = puppy.name,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPuppyListItem() {
    val puppy = DemoDataProvider.Edison
    MyTheme {
        PuppyListItem(puppy = puppy) { _, _ -> }
    }
}