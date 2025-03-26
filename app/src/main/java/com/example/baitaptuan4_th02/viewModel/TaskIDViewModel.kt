package com.example.baitaptuan4_th02.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baitaptuan4_th02.Attachment
import com.example.baitaptuan4_th02.RetrofitInstance
import com.example.baitaptuan4_th02.Subtask
import com.example.baitaptuan4_th02.TaskData
import kotlinx.coroutines.launch

class TaskIDViewModel(id : Int) : ViewModel() {
    private val _posts = mutableStateOf<TaskData?> (null)
    private val _subtasks = mutableStateOf<List<Subtask>>(emptyList())
    private val _attachments = mutableStateOf<List<Attachment>>(emptyList())
    val posts: MutableState<TaskData?> = _posts
    val subtasks: State<List<Subtask>> = _subtasks
    val attachments: State<List<Attachment>> = _attachments

    init {
        fetchTaskById(id)
    }

    fun fetchTaskById(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTaskById(id)  // Gọi API
                _posts.value = response.data  // Lưu toàn bộ TaskData
                _subtasks.value = response.data.subtasks  // Lưu danh sách subtasks
                _attachments.value = response.data.attachments  // Lưu danh sách attachments
            } catch (e: Exception) {
                Log.e("API_ERROR", "Lỗi xảy ra: ${e.localizedMessage}", e)
            }
        }

    }

}