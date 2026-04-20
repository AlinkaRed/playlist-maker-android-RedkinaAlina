package ru.yandex.practicum.playlistmarket.ui.screen

import android.content.Intent
import android.net.Uri
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
import ru.yandex.practicum.playlistmarket.R

@Composable
fun SettingsScreen() {
    val context = LocalContext.current
    val shareMessage = stringResource(id = R.string.share_app_message)
    val devEmail = stringResource(id = R.string.developer_email)
    val emailSubject = stringResource(id = R.string.email_subject)
    val emailBody = stringResource(id = R.string.email_body)
    val agreementUrl = stringResource(id = R.string.user_agreement_url)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.settings_title),
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, shareMessage)
                }
                context.startActivity(Intent.createChooser(shareIntent, null))
            }
        ) {
            Text(text = stringResource(id = R.string.share_app_button))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${Uri.encode(devEmail)}")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(devEmail))
                    putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                    putExtra(Intent.EXTRA_TEXT, emailBody)
                }
                val chooser = Intent.createChooser(
                    emailIntent,
                    context.getString(R.string.choose_email_app)
                )
                if (emailIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(chooser)
                } else {
                    Toast.makeText(
                        context,
                        context.getString(R.string.email_app_not_found),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text(text = stringResource(id = R.string.contact_developers_button))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val agreementIntent = Intent(Intent.ACTION_VIEW, Uri.parse(agreementUrl))
                val chooser = Intent.createChooser(
                    agreementIntent,
                    context.getString(R.string.choose_browser_app)
                )
                if (agreementIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(chooser)
                } else {
                    Toast.makeText(
                        context,
                        context.getString(R.string.browser_app_not_found),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text(text = stringResource(id = R.string.user_agreement_button))
        }
    }
}
