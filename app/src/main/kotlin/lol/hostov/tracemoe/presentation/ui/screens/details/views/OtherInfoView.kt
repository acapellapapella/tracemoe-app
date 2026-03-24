package lol.hostov.tracemoe.presentation.ui.screens.details.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lol.hostov.tracemoe.R
import lol.hostov.tracemoe.data.remote.model.AnilistResponse
import lol.hostov.tracemoe.presentation.theme.Theme

private fun String.capitalized() = this.lowercase().replaceFirstChar { it.uppercase() }

@Composable
fun OtherInfoView(item: AnilistResponse.MediaItem) {
	val unknown = stringResource(R.string.screen_result_unknown)

    val context = LocalContext.current
    val date = { date: AnilistResponse.MediaItem.Date? ->
    	if (date == null) context.getString(R.string.screen_result_unknown)
    	else if (date.day == 0 && date.month == 0 && date.year == 0) context.getString(R.string.screen_result_unknown)
    	else {
        	val months = context.resources.getStringArray(R.array.months)
        	"${date.day} ${months[(date.month ?: 1) - 1]} ${date.year}"
    	}
	}

    Column {
        InfoItem(
            title = stringResource(R.string.screen_result_startDate),
            value = date(item.startDate)
        )
        InfoItem(
            title = stringResource(R.string.screen_result_endDate),
            value = date(item.endDate)
        )
        InfoItem(
            title = stringResource(R.string.screen_result_season),
            value = item.season?.capitalized() ?: unknown
        )
        InfoItem(
            title = stringResource(R.string.screen_result_status),
            value = item.status.capitalized()
        )
        InfoItem(
            title = stringResource(R.string.screen_result_format),
            value = item.format?.capitalized() ?: unknown
        )
        InfoItem(
            title = stringResource(R.string.screen_result_duration),
            value = "${item.duration ?: "?"} min"
        )
        InfoItem(
            title = stringResource(R.string.screen_result_source),
            value = item.source?.capitalized() ?: unknown
        )
    }
}

@Composable
fun InfoItem(title: String, value: String) {
    Row(modifier = Modifier
        .padding(vertical = 6.dp)
        .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Theme.colors.textSecondary,
            modifier = Modifier.fillMaxWidth(0.5f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        SelectionContainer {
            Text(
                text = value,
                fontSize = 16.sp,
                color = Theme.colors.text,
            )
        }
    }
}
