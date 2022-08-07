package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.AndroidGreen
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun TitleLogo() {
    val image = painterResource(id = R.drawable.android_logo)
    Column(verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = "android_logo",
            modifier = Modifier.padding(start = 140.dp, end = 140.dp)
        )
        Text(
            text = stringResource(R.string.name),
            color = Color.LightGray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 40.sp
        )
        Text(
            text = stringResource(R.string.title),
            color = AndroidGreen,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInfo(picture: Int, info: String) {
    val image = painterResource(id = picture)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = image,
            contentDescription = info,
            Modifier.padding(end = 20.dp, start = 100.dp)
        )
        Text(text = info, color = Color.LightGray)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCard() {
    Surface(color = Color(0xFF003A4A), modifier = Modifier.fillMaxSize()) {
        TitleLogo()
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            ContactInfo(
                picture = R.drawable.ic_baseline_local_phone_24,
                info = stringResource(R.string.phone)
            )
            ContactInfo(
                picture = R.drawable.ic_baseline_share_24,
                info = stringResource(R.string.website)
            )
            ContactInfo(
                picture = R.drawable.ic_baseline_email_24,
                info = stringResource(R.string.email)
            )
        }
    }
}