package com.raywenderlich.android.jetnotes.util.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.raywenderlich.android.jetnotes.R
import com.raywenderlich.android.jetnotes.domain.model.NoteModel
import com.raywenderlich.android.jetnotes.util.components.Note
import com.raywenderlich.android.jetnotes.util.components.TopAppBar
import com.raywenderlich.android.jetnotes.viewmodel.MainViewModel


@Composable
fun NotesScreen(viewModel: MainViewModel) {
    val notes: List<NoteModel> by viewModel
        .notesNotInTrash
        .observeAsState(listOfNotNull())


    Column {
        TopAppBar(
            title = stringResource(id = R.string.notes),
            icon = Icons.Filled.List,
            onIconClick = {}
          )
        NotesList(
            notes = notes,
            onNoteCheckedChange = { viewModel.onNoteCheckedChange(it) },
            onNoteClick = { viewModel.onNoteClick(it) }
        ) }
    }


@Preview
@Composable
private fun NotesListPreview(){ NotesList(
    notes = listOfNotNull(
        NoteModel(1, "Note 1", "Content 1", null),
        NoteModel(1, "Note 2", "Content 2", null),
        NoteModel(1, "Note 3", "Content 3", null),
    ),
    onNoteCheckedChange = {}, onNoteClick = {}
)
}