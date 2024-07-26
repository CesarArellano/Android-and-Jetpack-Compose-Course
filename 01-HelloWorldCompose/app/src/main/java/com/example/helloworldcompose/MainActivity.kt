package com.example.helloworldcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainApp() {
    Scaffold(
        topBar = {Toolbar()},
        content= {Content()},
        floatingActionButton = { Fab() }
    )
}

@Composable
fun Fab() {
    val context = LocalContext.current;

    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "Hey Ray", Toast.LENGTH_SHORT).show()
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_message),
            contentDescription = "Icon Message"
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {Text(text = "RayWayDay", color= Color.White)},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorResource(id = R.color.top_bar_background)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ExampleModifier() {
    Text(text = "Subscribe", modifier = Modifier.padding(16.dp))
}

@Composable
fun Content() {
    var counter by rememberSaveable { mutableIntStateOf(value = 0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
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
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(counter.toString(), color=Color.White, modifier = Modifier.padding(start=4.dp))
                }
                Text(text = "RayWayDay", fontSize = 32.sp, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                Text(text = "Subscribe", color= Color.White)
                Text(text = "Hello", color = Color.White)
            }
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