package com.example.helloworldcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworldcompose.ui.theme.HelloWorldComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    HelloWorldComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            LazyColumnExample()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleModifier() {
    Text(text = "Subscribe", modifier = Modifier.padding(16.dp))
}

@Composable
fun LazyColumnExample() {
    var counter by rememberSaveable { mutableIntStateOf(value = 0) }

    LazyColumn(modifier = Modifier
        .background(Color.Red)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo Android",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
            )
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable {
                        counter++
                    }

                )
                Text(counter.toString(), color=Color.White, modifier = Modifier.padding(start=4.dp))
            }
            Text(text = "RayWayDay", fontSize = 32.sp, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Text(text = "Subscribe", color= Color.White)
            Text(text = "Hello", color = Color.White)
        }
    }
}


@Composable
fun RowExample() {
    LazyRow(
        contentPadding = PaddingValues(all = 10.dp),
        modifier= Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
    ) {
        item {
            Text("Hello", color = Color.White)
            Text("Jetpack Compose", color= Color.White)
            Text("Jetpack Compose", color= Color.White)
            Text("Jetpack Compose", color= Color.White)
            Text("Jetpack Compose", color= Color.White)
            Text("Jetpack Compose", color= Color.White)
            Text("Jetpack Compose", color= Color.White)
            Text("Jetpack Compose", color= Color.White)
        }
    }
}

@Composable
fun ColumnExample() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo Android",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
        )
        Text(text = "RayWayDay", fontSize = 32.sp, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Text(text = "Subscribe")
        Text(text = "Hello")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldComposeTheme {
        Greeting("Android")
    }
}