package com.danielhrndz.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danielhrndz.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            login()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun login() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.top_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
        )
        Text(
            text = "Welcome to Login UI",
            fontSize = 26.sp,
            color = Color.Magenta,
            modifier = Modifier
                .padding(top = 5.dp)
        )
        var user by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }
        var passwordVisible by rememberSaveable () { mutableStateOf(false) }
        TextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(text = "Enter Username") },
            modifier = Modifier
                .padding(top = 15.dp, start = 64.dp, end = 64.dp)
                .fillMaxWidth(),
        )
        TextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text(text = "Enter password") },
            modifier = Modifier
                .padding(top = 15.dp, start = 64.dp, end = 64.dp)
                .fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(
            onClick = { /*TODO*/ },
            Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(top = 20.dp, start = 64.dp, end = 64.dp),
            shape = RoundedCornerShape(10)
        ) {
            Text(
                text = "Login",
                fontSize = 20.sp,
            )
        }
        Text(
            text = "Don't remember password? Click here",
            Modifier
                .padding(top = 10.dp),
            color = Color.Magenta,
            textDecoration = TextDecoration.Underline,
        )
        Row(
            Modifier
                .padding(top = 20.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google", Modifier.padding(8.dp))
            Image(painter = painterResource(id = R.drawable.facebook), contentDescription = "Facebook", Modifier.padding(8.dp))
            Image(painter = painterResource(id = R.drawable.twitter), contentDescription = "Twitter", Modifier.padding(8.dp))
        }
        Image(
            painter = painterResource(id = R.drawable.bottom_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}
