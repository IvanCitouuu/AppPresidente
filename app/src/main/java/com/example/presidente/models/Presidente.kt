package com.example.presidente.models

import java.io.Serializable

data class President(
    val name: String,
    val term: String,
    val photoResId: Int,
    val bio: String,
    val milestones: List<String>
) : Serializable
