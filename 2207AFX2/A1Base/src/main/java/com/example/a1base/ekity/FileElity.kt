package com.example.a1base.ekity

data class FileElity(
    val code: Int,
    val `data`: List<FlieData>,
    val msg: String
)

data class FlieData(
    val bluck: String,
    val createTime: String,
    val id: Int,
    val info: String,
    val objName: String,
    val priority: Int,
    val resType: String,
    val type: String,
    val uid: Any,
    val url: String
)