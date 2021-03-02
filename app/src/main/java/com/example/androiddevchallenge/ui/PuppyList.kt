package com.example.androiddevchallenge.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.Puppy

@Composable
fun PuppyList(puppies: List<Puppy>, onClick: (position: Int, puppy: Puppy) -> Unit) {
    LazyColumn {
        items(puppies.size) { index: Int ->
            val puppy = puppies[index]
            PuppyListItem(puppy = puppy, onClick = onClick)
        }
    }
}