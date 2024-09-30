package com.umbr.jetpackcomposeandroid16

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainColumnScreen()
        }
    }
}

@Composable
fun MainBoxScreen() {
    Box(modifier = Modifier.fillMaxSize()) { // Анналогия FrameLayout
        Greeting("Android", modifier = Modifier.align(Alignment.Center))
        Greeting("Hello")
    }
}

@Composable
fun MainColumnScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {  // Анналогия LinearLayout orintetation vertical
        Greeting(
            "Android", modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth(0.2f)
        )
        Greeting("Hello", modifier = Modifier.padding(bottom = 40.dp))
        InputGreetingName()
        InputGreetingName()
        DefaultButton()
    }
}

@Composable
fun MainRowScreen() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {  // Анналогия LinearLayout orintetation horizontal
        Greeting("Android", modifier = Modifier.fillMaxWidth(0.2f))
        Greeting("Hello", modifier = Modifier)
        Greeting("Kello", modifier = Modifier.fillMaxWidth(0.5f))
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val a = name.first()
    Text( // Анналогия TextView
        text = "Hello $a!",
        modifier = modifier.background(color = androidx.compose.ui.graphics.Color.Companion.Blue),
        color = androidx.compose.ui.graphics.Color.Companion.Red,
        style = TextStyle(textAlign = TextAlign.Center)
    )
}

@Composable
fun InputGreetingName(modifier: Modifier = Modifier) {
    var textState by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = modifier,
        value = textState,
        onValueChange = { textState = it },
        label = { Text(text = "Input your name", color = Color.Gray) },
        shape = RoundedCornerShape(20.dp),
//        modifier = Modifier.background(
//            brush = Brush.verticalGradient(
//                listOf(
//                    Color.White,
//                    Color.Gray
//                )
//            ), shape = RoundedCornerShape(20.dp)
//        )
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        ),
        leadingIcon = {
            DefaultIcon(Icons.Outlined.Face)
        },
        trailingIcon = {
            DefaultIcon(Icons.Outlined.Home)
        }
    )
}

@Composable
fun DefaultIcon(imageVector: ImageVector, modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier.clickable(false) { }, // нажатия используя Modifier
        imageVector = imageVector,
//        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = stringResource(R.string.descriptionDefaultIcon),
        tint = Color.Red
    )
}

@Composable
fun DefaultButton(modifier: Modifier = Modifier) {
    var isEnable by remember {
        mutableStateOf(true)
    }
    Button(
        modifier = modifier,
        enabled = isEnable,
        onClick = { isEnable = !isEnable },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            disabledContainerColor = Color.Red
        )
    ) {
        Text(text = "Type on me")
    }
}

@Preview
@Composable
fun GreetingPreview() {
    Greeting(name = "Android")
}

@Preview
@Composable
fun MainScreenPreview() {
    MainColumnScreen()
}