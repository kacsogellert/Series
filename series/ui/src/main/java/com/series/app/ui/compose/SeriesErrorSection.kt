package com.series.app.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.series.app.series.ui.R
import com.series.app.shared.SeriesTheme

@Composable
fun SeriesErrorSection(onTryAgainClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SeriesTheme.dimens.contentPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(80.dp)
                .padding(start = SeriesTheme.dimens.smallPadding),
            imageVector = Icons.Rounded.Warning,
            tint = Color.Yellow,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(SeriesTheme.dimens.padding))
        Text(
            text = stringResource(R.string.series_download_error),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Medium),
        )
        Spacer(modifier = Modifier.height(SeriesTheme.dimens.contentPadding))
        Button(onClick = onTryAgainClick) {
            Text(
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                text = stringResource(R.string.series_try_again)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun SeriesErrorSectionPreview() {
    SeriesErrorSection {
    }
}
