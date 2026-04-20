package com.example.playlistmaker.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.playlistmaker.R

@Composable
fun MainScreen(
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSearchClick
        ) {
            Text(text = stringResource(id = R.string.search_title))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Toast.makeText(
                    context,
                    context.getString(R.string.library_stub_message),
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text(text = stringResource(id = R.string.library_title))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSettingsClick
        ) {
            Text(text = stringResource(id = R.string.settings_title))
        }
    }
}
