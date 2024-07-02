package com.example.appcinema.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.appcinema.R
import com.example.appcinema.ui.theme.Black
import com.example.appcinema.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Black,
            actionIconContentColor = White,
            navigationIconContentColor = White,
        ),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.cinema),
                    contentDescription = "Popcorn Icon",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Cine IREDE", color = White)
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.sensor_door),
                    contentDescription = "Localized description",
                    modifier = Modifier.width(28.dp)
                )
            }
        },
        actions = {
            var expanded by remember { mutableStateOf(false) }
            IconButton(onClick = { expanded = true }, Modifier.padding(8.dp)) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description"
                )
            }
            DropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black),
                expanded = expanded,

                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Home", color = Color.White)
                    },
                    onClick = {
                        // Handle click
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                )

                DropdownMenuItem(
                    text = {
                        Text("Filmes", color = Color.White)
                    },
                    onClick = {
                        // Handle click
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Movie,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text("Séries", color = Color.White)
                    },
                    onClick = {
                        // Handle click
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.popcorn),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text("Ir para Favoritos", color = Color.White)
                    },
                    onClick = {
                        // Handle click
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}