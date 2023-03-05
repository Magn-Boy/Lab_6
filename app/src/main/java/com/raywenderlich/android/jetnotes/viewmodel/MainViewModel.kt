package com.raywenderlich.android.jetnotes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.android.jetnotes.data.repository.Repository
import com.raywenderlich.android.jetnotes.domain.model.NoteModel
import kotlinx.coroutines.launch

/**
 * View model used for storing the global app state.
 *
 * This view model is used for all screens.
 */
class MainViewModel(private val repository: Repository) : ViewModel() {

    val notesNotInTrash: LiveData<List<NoteModel>> = repository.getAllNotesNotInTrash()
    fun onCreateNewNoteClick(){

    }

    fun onNoteClick(note: NoteModel){

    }

    fun onNoteCheckedChange(
        note: NoteModel
    ) {
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }
}



