package com.example.animatecolorstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatecolorstate.ui.theme.AnimateColorStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimateColorStateTheme{
                Scaffold{
                    Column(
                        modifier = Modifier.padding(it)
                            .fillMaxSize()
                            .wrapContentHeight()
                    ) {
                        Spacer(modifier = Modifier.height(38.dp))
                        Animate()
                    }

                }


            }
        }
    }
}

@Composable
private fun Animate(){
    var isColorchanged by remember {
        mutableStateOf(false)
    }
    val targetColor by animateColorAsState(
        targetValue = if(isColorchanged) Color.Green else Color.Cyan,
        label="",
        animationSpec = tween(500)
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Card(
            border = BorderStroke(7.dp, Color.Yellow),
            colors = CardDefaults.cardColors(targetColor),
            modifier = Modifier
                .padding(8.dp)
                .height(200.dp)
                .fillMaxSize()
        ) {
            Column (modifier = Modifier.padding(10.dp))
            {

            Text(text = "Card Explains", style = MaterialTheme.typography.headlineMedium, color = Color.Black )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "This is a new mini step to learning Jetpack Compose", color = Color.DarkGray)

        }

        }
        Button(onClick = { isColorchanged = !isColorchanged },
            modifier = Modifier.padding(top=12.dp)
            ) {
            Text(text = "Change Color")
            
        }

    }
}