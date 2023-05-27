package com.h2square.lottogenerater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.h2square.lottogenerater.ui.theme.LottoGeneraterTheme
import kotlin.random.Random


//fun main(){
//    val lottoNumberRange=(1..45)
//    lottoNumberRange.random()
//
//    println(lottoNumberRange.random())
//}

fun Color.Companion.random():Color{
    val red= Random.nextInt(256)
    val green=Random.nextInt(256)
        val blue =Random.nextInt(256)
    return Color(red, green, blue)
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoGeneraterTheme {

                //데이터
                //상수
                val buttonTitle="로또번호생성"
                //번호 생성 횟수
                var generatedCount by remember{ mutableStateOf(0) }


                var generatedCount01 by remember{ mutableStateOf(0) }
                var generatedCount02 by remember{ mutableStateOf(0) }
                var generatedCount03 by remember{ mutableStateOf(0) }
                var generatedCount04 by remember{ mutableStateOf(0) }
                var generatedCount05 by remember{ mutableStateOf(0) }
                var generatedCount06 by remember{ mutableStateOf(0) }
                var generatedCount07 by remember{ mutableStateOf(0) }


                val lottoNumberRange=(1..45)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(modifier= Modifier
                        .fillMaxWidth()
                        .padding(all = 10.dp)
                        .padding(vertical = 40.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {


                        LottoBall(generatedCount01)
                        LottoBall(generatedCount02)
                        LottoBall(generatedCount03)
                        LottoBall(generatedCount04)
                        LottoBall(generatedCount05)
                        LottoBall(generatedCount06)
                        LottoBall(generatedCount07)

                        }
                    Spacer(modifier = Modifier.height(150.dp))
                    Text(text = "생성된횟수:$generatedCount", fontSize = 30.sp)
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(onClick = {
                        generatedCount01=lottoNumberRange.random()
                        generatedCount02=lottoNumberRange.random()
                        generatedCount03=lottoNumberRange.random()
                        generatedCount04=lottoNumberRange.random()
                        generatedCount05=lottoNumberRange.random()
                        generatedCount06=lottoNumberRange.random()
                        generatedCount07=lottoNumberRange.random()
                        generatedCount ++

                    }) {
                        Text(buttonTitle, fontSize = 30.sp)

                    }
                    }
                }
                }
            }
        }
    }


@Composable
fun LottoBall(number:Int){
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.random()),
        contentAlignment = Alignment.Center
    ){
        Text(number.toString(),
            fontSize = 20.sp,
            color = Color.White


        )
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



}