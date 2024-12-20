package com.example.a1base.base

import com.example.a1base.ekity.FlieData

sealed class BaseStr {
    data object baseStr: BaseStr()
    data class  BaseFlie(val list: List<FlieData>): BaseStr()
}