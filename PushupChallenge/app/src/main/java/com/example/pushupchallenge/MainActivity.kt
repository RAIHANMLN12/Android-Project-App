package com.example.pushupchallenge

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pushupchallenge.data.Challenge
import com.example.pushupchallenge.data.challenges
import com.example.pushupchallenge.ui.theme.PushUpChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PushUpChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PushUpApp()
                }
            }
        }
    }
}

@Composable
fun PushUpApp() {
    Scaffold(
        topBar = {
            // Top App Bar
            TopAppBar(
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.fillMaxWidth().size(height = 80.dp, width = 80.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.h1
                    )
                }
            }
        }
    ) {
        // Show card item
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(challenges) {
                CardView(challenge = it)
            }
        }
    }
}
@Composable
fun CardView(challenge: Challenge) {

    var expanded: Boolean by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { expanded = !expanded }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessHigh
                )
            )
        ,
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                ,
        ) {
            Text(
                text = stringResource(id = challenge.day),
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.h1,
            )
            Image(
                painter = painterResource(challenge.imageDesc),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(200.dp)
            )
            if(expanded){
                Text(
                    text = stringResource(id = challenge.workout),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.body1,
                )
            }

        }
    }
}

@Preview
@Composable
fun LightThemePreview() {
    PushUpChallengeTheme(darkTheme = false) {
        PushUpApp()
    }
}

@Preview
@Composable
fun DarkThemePreview() {
    PushUpChallengeTheme(darkTheme = true) {
        PushUpApp()
    }
}