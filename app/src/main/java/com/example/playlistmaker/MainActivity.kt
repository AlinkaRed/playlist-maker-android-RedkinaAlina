package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.playlistmaker.ui.theme.PlaylistMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistMakerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        onSearchClick = {
                            startActivity(Intent(this, SearchActivity::class.java))
                        },
                        onLibraryClick = {
                            Toast.makeText(this, getString(R.string.library_stub_message), Toast.LENGTH_SHORT)
                                .show()
                        },
                        onSettingsClick = {
                            startActivity(Intent(this, SettingsActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun MainScreen(
    onSearchClick: () -> Unit,
    onLibraryClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Playlist Maker",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSearchClick
        ) {
            Text(text = "Поиск")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onLibraryClick
        ) {
            Text(text = "Медиатека")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSettingsClick
        ) {
            Text(text = "Настройки")
        }
    }
}
