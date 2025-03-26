    package com.example.baitaptuan4_th02.viewModel

    import android.util.Log
    import androidx.compose.runtime.State
    import androidx.compose.runtime.mutableStateOf
    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.example.baitaptuan4_th02.Attachment
    import com.example.baitaptuan4_th02.RetrofitInstance
    import com.example.baitaptuan4_th02.Subtask
    import com.example.baitaptuan4_th02.TaskData
    import kotlinx.coroutines.launch

    class TaskViewModel : ViewModel() {
        private val _posts = mutableStateOf<List<TaskData>>(emptyList())
        private val _subtasks = mutableStateOf<List<Subtask>>(emptyList())
        private val _attachments = mutableStateOf<List<Attachment>>(emptyList())
        val posts: State<List<TaskData>> = _posts
        val subtasks: State<List<Subtask>> = _subtasks
        val attachments: State<List<Attachment>> = _attachments

        init {
            fetchTasks()
        }

        private fun fetchTasks() {
            viewModelScope.launch {
                try {
                   _posts.value = RetrofitInstance.api.getTask().data

                } catch (e: Exception) {
                    Log.e("ERROR_TAG", "Lỗi xảy ra: ${e.message}")
                }
            }
        }

    }