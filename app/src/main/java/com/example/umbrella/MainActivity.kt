package com.example.umbrella

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.umbrella.ui.theme.UmbrellaTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayMainContent()
        }
    }
}

@Composable
fun DisplayMainContent() {
    UmbrellaTheme{
        val scaffoldState = rememberScaffoldState()
        val scaffoldCoroutineScope = rememberCoroutineScope()
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                scaffoldState = scaffoldState,
                floatingActionButton = {
                    ExtendedFloatingActionButton(text = {Text(text="Add City")}, modifier = Modifier.padding(start = 24.dp), onClick= {
                        scaffoldCoroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("City Added")
                        }
                    })
               },
                content = {
                    Column{
                        Text(text="Weather Graphic Here")
                        Text(text="Cities Observed Here")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainContent() {
    DisplayMainContent()
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewMainContentDark() {
    DisplayMainContent()
}