package com.thn.codingassessment.android.ui.screen.movie_search.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.thn.codingassessment.android.core.provider.LocalKeyBoardManager
import com.thn.codingassessment.android.ui.resources.CodingAssessmentTheme
import com.thn.codingassessment.android.ui.resources.StringRes
import com.thn.codingassessment.android.ui.uiComponents.textView.CommonText

@Composable
fun SearchBar(onSearch: (String) -> Unit, onClear: () -> Unit) {
    var query by remember { mutableStateOf("") }
    val keyboardManager = LocalKeyBoardManager.current

    OutlinedTextField(
        value = query,
        onValueChange = { if (it.isNotBlank() || query.isNotEmpty()) {
            query = it
        }},
        placeholder = { CommonText(text = StringRes.SEARCH_FOR_MOVIES) },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = {
                    query = ""
                    onClear.invoke()
                }) {
                    Icon(Icons.Default.Close, contentDescription = "Clear", tint = CodingAssessmentTheme.secondary)
                }
            }
        },

        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            keyboardManager.hideKeyboard()
            onSearch(query.trim())
        }),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}
