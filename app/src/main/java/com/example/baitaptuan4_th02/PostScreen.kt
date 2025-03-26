package com.example.baitaptuan4_th02

import com.example.baitaptuan4_th02.emptyLayout.EmptyList
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import com.example.baitaptuan4_th02.viewModel.TaskViewModel


@Composable
fun PostScreen(viewModel: TaskViewModel, navController: NavController) {
    val posts by viewModel.posts
    LaunchedEffect(posts) {
        println("Posts đã cập nhật: ${posts.size}")
    }
    if (posts.isEmpty()) {
        EmptyList()
    }
    else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 20.dp, start = 20.dp),
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
            LazyColumn (
                modifier = Modifier
                    .padding(10.dp)
            ){
                items(posts.size) { index ->
                    PostCard(post = posts[index], navController
                    )
                }
            }

        }

    }
}

@Composable
fun PostCard(post: TaskData, navController: NavController
) {
    val cardColor = when(post.priority) {
        "High" -> colorResource(R.color.secondary_color)
        "Medium" -> colorResource(R.color.medium_color)
        else -> colorResource(R.color.low_color)
    }
    Card (
        modifier = Modifier
            .fillMaxSize().padding(bottom = 15.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ){
        Column (){
            Row (
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var checkState by remember { mutableStateOf(false) }
                Checkbox(
                    checked = checkState,
                    onCheckedChange = { checkState = !checkState},
                    colors = CheckboxDefaults.colors(Color.Black)
                )
                Column (
                    Modifier.weight(1f).padding(end = 20.dp)
                ) {
                    Text(text = "${post.title}", fontWeight = FontWeight.Bold, fontSize = 17.sp, modifier = Modifier.padding(top = 20.dp, bottom = 5.dp))
                    Text(text = "${post.description}", fontSize = 17.sp, modifier = Modifier.padding(5.dp))

                }
                Surface(shape = RoundedCornerShape(12.dp),
                    color = Color.Black,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clickable {
                            navController.navigate("detail/${post.id}")
                            Log.e("API_ERROR", "${post.id}")
                        },
                ) {
                    Image(
                        painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = null,
                        Modifier.padding(10.dp)
                    )
                }
            }

            Row {
                Text(
                    text = "Status: ${post.status}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp, bottom = 10.dp)
                )
            }
        }

    }
}

@Preview
@Composable
fun pvPostScreen(modifier: Modifier = Modifier) {
    pvPostScreen()
}
