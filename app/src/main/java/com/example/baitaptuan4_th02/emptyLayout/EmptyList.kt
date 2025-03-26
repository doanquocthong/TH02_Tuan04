package com.example.baitaptuan4_th02.emptyLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baitaptuan4_th02.R

@Composable
fun EmptyList() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 20.dp, start = 20.dp)
    ) {
        Row (modifier = Modifier
            .padding(top = 40.dp, bottom = 10.dp, start = 10.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Surface(
                color = colorResource(R.color.background_uth),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .width(60.dp).height(60.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_uth),
                    contentDescription = null,
                    Modifier.padding(5.dp)
                )
            }
            Column (
                modifier = Modifier
                    .weight(1f).padding(start = 10.dp)
            ){
                Text(
                    "SmartTasks",
                    color = colorResource(R.color.primary_color),
                    modifier = Modifier,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    "A simple and efficient to-do app",
                    color = colorResource(R.color.primary_color),
                    modifier = Modifier,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Box(modifier = Modifier.size(40.dp)) {
                Image(
                    painter = painterResource(R.drawable.baseline_doorbell_24),
                    contentDescription = "Thông báo",
                    modifier = Modifier.fillMaxSize()
                )
                Surface(
                    color = Color.Red, // Màu đỏ cho chấm thông báo
                    shape = CircleShape,
                    modifier = Modifier
                        .size(10.dp) // Kích thước chấm đỏ
                        .align(Alignment.TopEnd) // Canh về góc phải trên
                        .offset(x = (-8).dp, y = 11.dp)
                ) {}
            }


        }
        Surface(
            shape = RoundedCornerShape(18.dp),
            modifier = Modifier
                .fillMaxWidth().padding(top = 30.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.empty),
                contentDescription = null,
                Modifier.padding(0.dp)
            )
        }



    }
}

@Preview (showBackground = true)
@Composable
fun pvEmptyList() {
    EmptyList()
    
}