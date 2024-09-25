package com.raywayday.mapcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState
import com.raywayday.mapcompose.ui.theme.MapComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyGoogleMaps()
                }
            }
        }
    }
}

@Composable
fun MyGoogleMaps() {
    val markerState = rememberMarkerState(position = LatLng(20.7505397, -99.9461831))
    val properties by remember {
        mutableStateOf(MapProperties(
            mapType = MapType.NORMAL
        ))
    }
    val uiSettings by remember {
        mutableStateOf(MapUiSettings(
            zoomControlsEnabled = false
        ))
    }
    GoogleMap(
        properties = properties,
        uiSettings = uiSettings,
    ) {
        Marker(
            state = markerState,
            title = "Peña de Bernal",
            snippet= "Pueblo Mágico en Querétaro"
        )
    }
}