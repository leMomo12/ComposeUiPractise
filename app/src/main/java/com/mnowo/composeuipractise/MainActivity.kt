package com.mnowo.composeuipractise

import android.app.LauncherActivity
import android.app.UiModeManager.MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mnowo.composeuipractise.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeUiPractiseTheme {
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    scaffoldState = scaffoldState,
                    bottomBar = {
                        BottomBar()
                    }
                ) {
                    Column {
                        UserInfoCard()
                        OverviewRow()
                        List()
                    }
                }
            }
        }
    }
}

@Composable
fun UserInfoCard() {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(310.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row {
                Icon(
                    Icons.Filled.Share,
                    contentDescription = "",
                    tint = onPrimaryColor,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                )

                Spacer(modifier = Modifier.padding(horizontal = 140.dp))

                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "",
                    tint = onPrimaryColor,
                    modifier = Modifier.padding(top = 10.dp, end = 10.dp)
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(
                            CircleShape
                        )
                        .size(100.dp)
                )
            }
            Text(
                text = "Hira Riaz",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "UI/UX Designer",
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = black
            )
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = "$8900",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif
                )

                Divider(
                    color = Color.Gray, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)

                )

                Text(
                    text = "$8900",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif
                )
                Divider(
                    color = Color.Gray, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)

                )

                Text(
                    text = "$8900",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 27.dp, end = 27.dp)
            ) {
                Text(
                    text = "Income",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    color = black
                )
                Text(
                    text = "Expenses",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    color = black,
                    modifier = Modifier.padding(end = 13.dp)
                )
                Text(
                    text = "Loan",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    color = black
                )
            }
        }
    }
}

@Composable
fun BottomBar() {
    BottomAppBar(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .background(backgroundColor),
        content = {
            BottomNavigation {

                BottomNavigationItem(
                    selected = true, onClick = { },
                    icon = {
                        Icon(
                            Icons.Default.Home,
                            "",
                            tint = iconColor
                        )
                    },
                )

                BottomNavigationItem(selected = false, onClick = { },
                    icon = {
                        Icon(
                            Icons.Outlined.ShoppingCart,
                            "",
                            tint = iconColor
                        )
                    })

                BottomNavigationItem(selected = false, onClick = { },
                    icon = {
                        Box(
                            modifier = Modifier
                                .height(45.dp)
                                .width(45.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(onPrimaryColor),
                        ) {
                            Icon(
                                Icons.Default.Add,
                                "",
                                tint = primary,
                                modifier = Modifier.align(Center)
                            )
                        }
                    })

                BottomNavigationItem(selected = false, onClick = { },
                    icon = {
                        Icon(
                            Icons.Outlined.Phone,
                            "",
                            tint = iconColor
                        )
                    })

                BottomNavigationItem(selected = false, onClick = { },
                    icon = {
                        Icon(
                            Icons.Outlined.Person,
                            "",
                            tint = iconColor
                        )
                    })
            }
        }
    )
}

@Composable
fun OverviewRow() {
    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Overview",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = onPrimaryColor
        )
    }
}

@Composable
fun ListItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Color.White)
                .padding(5.dp),
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = lightOnPrimary,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            ) {

                Icon(Icons.Default.ArrowBack, contentDescription = "")
            }
            Column(Modifier.padding(start = 70.dp)) {
                Text(
                    text = "Sent",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "Sent money to my family",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Text(
                text = "$235",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .align(BottomEnd)
                    .padding(bottom = 10.dp, end = 5.dp)
            )
        }
    }
}


@Composable
fun List() {
    LazyColumn(Modifier.fillMaxSize()) {
        items(10) {
            ListItem()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeUiPractiseTheme {
        ListItem()
    }
}