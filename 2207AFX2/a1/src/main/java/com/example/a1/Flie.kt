package com.example.a1


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.a1base.base.BaseInt
import com.example.a1base.base.BaseStr
import com.example.a1base.base.BaseViewModel
import com.example.a1base.ekity.FlieData
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

@Preview
@Composable
fun Files(vie: BaseViewModel= hiltViewModel()) {
     val context = LocalContext.current
    val list = remember {
        SnapshotStateList<FlieData>()
    }

    LaunchedEffect(key1 = "", block = {
        launch {
            vie.sta.collect{
                when(it){
                    is BaseStr.BaseFlie ->{
                        list.addAll(it.list)
                        Log.i("aa", list.toString())
                    }
                    BaseStr.baseStr -> {
                        Toast.makeText(context,"加载完成",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        launch {
            vie.c.send(BaseInt.baseInt)
        }
    })
    LazyColumn (modifier = Modifier.fillMaxSize()){
         items(list){ item ->
             Fike(item = item,context)
         }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Fike(item: FlieData, context: Context) {
    //右布局上下二行文本
    Column(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            model = item.url,
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .align(CenterHorizontally)
                .combinedClickable(
                    onClick = {
                        Toast.makeText(context, "点击下载", Toast.LENGTH_SHORT).show()
                    },
                    onLongClick = {
                        Toast.makeText(context, "长按删除", Toast.LENGTH_SHORT).show()
                    }
                )
        )
        Text(text = item.info)
        Text(item.createTime)
    }
}


