package com.example.baitaptuan4_th02

import android.provider.CalendarContract.Reminders

class ApiResponse<T>(
    val isSuccess: Boolean,
    val message: String,
    val data: T
)

data class TaskData(
    val id: Int,
    val title: String,
    val description: String,
    val status: String,
    val priority: String,
    val category: String,
    val subtasks: List<Subtask>,
    val attachments: List<Attachment>,
    val reminders: List<Reminders>,
)

data class Subtask(
    val id: Int,
    val title: String,
)

data class Attachment(
    val id: Int,
    val fileName: String,
)

data class reminders(
    val id: Int,
    val timme: String
)

