package com.productivityservicehub.emathquiz.Components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.productivityservicehub.emathquiz.DataClass.Level
import com.productivityservicehub.emathquiz.R


@Composable
fun customButton(value :String ){
    Button(onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ){
        Box(modifier = Modifier.fillMaxWidth()
            .heightIn(48.dp)
            .background(
                Brush.horizontalGradient(listOf(Color.Blue, Color.Cyan)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
        ){
            Text(text = value , fontSize = 18.sp , fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun CardComp(navCon:NavController){
    Card(modifier = Modifier.fillMaxWidth().heightIn(48.dp).padding(28.dp).clickable{
        navCon.navigate("level_screen")
    },
    ){
        Row(modifier = Modifier.fillMaxWidth()
            .heightIn(48.dp).padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(R.drawable.email) , contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = stringResource(R.string.Play),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}



@Composable
fun CustomKeyboard(onKeyClick: (String) -> Unit) {
    val keys = listOf(
        listOf("Answer", "X", "💡", "ENTER"),
        listOf("1", "2", "3", "4", "5"),
        listOf("6", "7", "8", "9", "0")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp)
    ) {
        keys.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { key ->
                    KeyButton(
                        text = key,
                        onClick = { onKeyClick(key) }
                    )
                }
            }
        }
    }

}

@Composable
fun KeyButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(Color.DarkGray, RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}