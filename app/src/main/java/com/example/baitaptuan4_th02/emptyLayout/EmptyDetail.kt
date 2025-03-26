package com.example.baitaptuan4_th02.emptyLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baitaptuan4_th02.R

@Composable
fun EmptyDetail() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 20.dp, start = 20.dp)
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)){
            Box(){
                Surface(
                    color = colorResource(R.color.primary_color),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .clickable {}
                )
                {
                    Image(
                        painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 10.dp, start = 15.dp, end = 10.dp, bottom = 10.dp)
                    )
                }
            }
                Text(
                    "Detail",
                    color = colorResource(R.color.primary_color),
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            Surface (
                shape = CircleShape,
                color = colorResource(R.color.trash_color),
                modifier = Modifier
                    .size(50.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.baseline_restore_from_trash_24),
                    contentDescription = null,
                    Modifier.padding(8.dp)
                )
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
fun pvEmptyDetail() {
    EmptyDetail()
}