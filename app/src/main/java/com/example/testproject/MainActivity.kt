package com.example.testproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproject.ui.theme.TestProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop, // 이미지 해상도
            alpha = 0.5f // 이미지 투명도
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
    }
}

@Composable
fun LearnTogether(title: String, subTitle: String, text: String){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = subTitle,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = text,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManager(title: String, subTitle: String){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = subTitle,
            fontSize = 16.sp
        )

    }
}

@Composable
fun Quarters(){
    Column(
       Modifier.fillMaxWidth()
    ) {
        Row(Modifier.weight(1f)) {
            QuartersText(
                title = stringResource(R.string.Quarters_first_title),
                text = stringResource(R.string.Quarters_first_text),
                backColor = colorResource(R.color.Quarters_first_color),
                modifier = Modifier.weight(1f)
            )
            QuartersText(
                title = stringResource(R.string.Quarters_second_title),
                text = stringResource(R.string.Quarters_second_text),
                backColor = colorResource(R.color.Quarters_second_color),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuartersText(
                title = stringResource(R.string.Quarters_third_title),
                text = stringResource(R.string.Quarters_third_text),
                backColor = colorResource(R.color.Quarters_thirds_color),
                modifier = Modifier.weight(1f)
            )
            QuartersText(
                title = stringResource(R.string.Quarters_fourth_title),
                text = stringResource(R.string.Quarters_fourth_text),
                backColor = colorResource(R.color.Quarters_fourth_color),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuartersText(title: String, text: String, backColor: Color, modifier: Modifier = Modifier){
    Column(
        modifier = modifier // modifier를 전달 받음으로써 균등한 범위 내에서만 보이도록
            .fillMaxSize()
            .background(backColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun BusinessCard(name: String, job: String, phone: String, url: String, mail: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(top = 130.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.business_card),
                contentDescription = null,
                Modifier
                    .padding(top = 100.dp, start = 130.dp, end = 130.dp, bottom = 16.dp)
                    .background(Color.DarkGray)
            )
            Text(
                text = name,
                fontSize = 36.sp
            )
            Text(
                text = job,
                fontSize = 18.sp,
                color = Color.Green,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
        Column(
            modifier = Modifier.padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = phone,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            )
            Text(
                text = url,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            )
            Text(
                text = mail,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    TestProjectTheme {
//        LearnTogether(
//            title = stringResource(R.string.LearnTogether_title),
//            subTitle = stringResource(R.string.LearnTogether_subTitle),
//            text = stringResource(R.string.LearnTogether_text)
//        )
//        TaskManager(
//            title = stringResource(R.string.TaskManager_title),
//            subTitle = stringResource(R.string.TaskManager_subTitle)
//        )
        BusinessCard(
            name = "Choi Yoon Soo",
            job = "Android Developer",
            phone = "010-1234-5678",
            url = "@github",
            mail = "test@gmail.com"
        )
    }
}