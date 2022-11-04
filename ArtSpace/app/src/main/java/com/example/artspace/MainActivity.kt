package com.example.artspace

import android.icu.text.CaseMap.Title
import android.media.Image
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }

    @Composable
    fun ArtSpaceApp() {
        var result by remember {
            mutableStateOf(1)
        }

        var art = when(result) {
            0, 1 -> ArtImageAndTitleAndButton(
                drawableImage = R.drawable.picture_beach, 
                imageLabel = R.string.beach, 
                title = R.string.beach,
                previousClick = {result--},
                nextClick = {result++}
            )
            
            2 -> ArtImageAndTitleAndButton(
                drawableImage = R.drawable.picture_flower, 
                imageLabel = R.string.flower,
                title = R.string.flower,
                previousClick = {result--},
                nextClick = {result++}
            )
            
            3 -> ArtImageAndTitleAndButton(
                drawableImage = R.drawable.picture_forest, 
                imageLabel = R.string.forest, 
                title = R.string.forest,
                previousClick = {result--},
                nextClick = {result++}
            )
            
            else -> ArtImageAndTitleAndButton(
                drawableImage = R.drawable.picture_mountain, 
                imageLabel = R.string.mountain, 
                title = R.string.mountain,
                previousClick = {result--},
                nextClick = {result++}
            )
        }
    }

    @Composable
    fun ArtImageAndTitleAndButton(drawableImage: Int, imageLabel: Int, modifier: Modifier =
        Modifier,
                         title: Int, previousClick: () -> Unit, nextClick: () -> Unit) {
        Column(
            modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement
                .Center, horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(drawableImage),
                contentDescription = stringResource(id = imageLabel),
                modifier = Modifier
                    .wrapContentSize()
                    .border(BorderStroke(2.dp, Color.DarkGray))
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = stringResource(title), fontSize = 24.sp)
            Spacer(modifier = Modifier.height(10.dp))

            Row(modifier = Modifier.padding(16.dp),  horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = previousClick) {
                    Text(text = "Previous", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                }
                Button(onClick = nextClick) {
                    Text(text = "Next", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                }
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ArtSpaceTheme {
            ArtSpaceApp()
        }
    }
}

