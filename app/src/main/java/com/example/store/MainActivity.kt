package com.example.store

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.store.ui.theme.StoreTheme
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TopBar()
                }
            }
        }
        @Composable
        fun MainScreen() {
            Scaffold(
                topBar = { TopBar() },
                bottomBar = { BottomNavigationBar() }
            ) {
                /* Add code later */
            }
        }

    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = White
    )
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Music,
        NavigationItem.Movies,
        NavigationItem.Books,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.colorPrimary),
        contentColor = White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = White,
                unselectedContentColor = White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StoreTheme {
        BottomNavigationBar()
    }
}