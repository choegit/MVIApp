package com.example.mviapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GreetingScreen(viewModel: GreetingViewModel = viewModel()) {

    //User types a name and taps a button → app shows: "Hello, [Name]"
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = state.name,
            onValueChange = {
                viewModel.processIntent(GreetingIntent.EnterName(it))
            },
            label = {Text("Enter your name")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
            viewModel.processIntent(GreetingIntent.Greet)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Greet")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = state.greeting,
            style = MaterialTheme.typography.headlineSmall
        )

    }
}