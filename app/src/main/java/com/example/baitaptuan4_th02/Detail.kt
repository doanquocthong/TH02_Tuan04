package com.example.baitaptuan4_th02

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.baitaptuan4_th02.emptyLayout.EmptyDetail
import com.example.baitaptuan4_th02.viewModel.TaskIDViewModel

@Composable
fun Detail(
    taskId: Int, // Nhận ID từ màn hình trước
    viewModel: TaskIDViewModel,
    navController: NavController
) {
    val post by viewModel.posts
    val subtasks by viewModel.subtasks
    val attachments by viewModel.attachments

    if (post==null) {
        EmptyDetail()
    }
    else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Surface(
                        color = colorResource(R.color.primary_color),
                        shape = RoundedCornerShape(18.dp),
                        modifier = Modifier
                            .width(45.dp)
                            .height(45.dp)
                            .clickable { navController.popBackStack() }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                            contentDescription = "Back",
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
            post?.let { postData ->
                subTask(postData, subtasks, attachments)
            }
        }
    }
}

@Composable
fun subTask(post: TaskData, subtasks: List<Subtask>, attachments: List<Attachment>) {

    Text(
        text = post.title,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        modifier = Modifier.padding(top = 20.dp)
    )
    Text(
        text = post.description,
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)

    )
    Surface(
        color = colorResource(R.color.surface_color2),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .height(100.dp),
    ) {
        Row (
            modifier = Modifier
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row (
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_category_24),
                    contentDescription = null,
                    Modifier.size(30.dp).padding(end = 5.dp)

                )
                Column () {
                    Text(
                        "Category",
                        fontSize = 15.sp
                    )
                    Text(
                        "${post.category}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row (
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_playlist_add_check_24),
                    contentDescription = null,
                    Modifier.size(30.dp).padding(end = 5.dp)

                )
                Column () {
                    Text(
                        "Status",
                        fontSize = 15.sp
                    )
                    Text(
                        "${post.status}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row (
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_assured_workload_24),
                    contentDescription = null,
                    Modifier.size(30.dp).padding(end = 5.dp)
                )
                Column () {
                    Text(
                        "Priority",
                        fontSize = 15.sp
                    )
                    Text(
                        "${post.priority}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }


    }
    Text(
        text = "Subtasks",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 10.dp)
    )
    subtasks.forEach { subtask ->
    Surface(
        color = colorResource(R.color.surface_color),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .padding(top = 20.dp, end = 10.dp)
            .fillMaxWidth()
    ) {
    Row {
        var checkState by remember { mutableStateOf(false) }
        Checkbox(
            checked = checkState,
            onCheckedChange = {checkState = !checkState},
            colors = CheckboxDefaults.colors(Color.Black)
        )
         Text(
                text = "${subtask.title}",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                )
            }

        }

    }

    Text(
        text = "Attachments",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 10.dp)
    )

    attachments.forEach { attachment ->
        Surface(
            color = colorResource(R.color.surface_color),
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier
                .padding(top = 20.dp, end = 10.dp)
                .fillMaxWidth()
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.baseline_attach_file_24),
                    contentDescription = null,
                    modifier =Modifier
                        .padding(top = 10.dp, start = 10.dp),
                )
                Text(
                    text = "${attachment.fileName}",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp)

                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetail() {
}
