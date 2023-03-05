package com.raywenderlich.android.jetnotes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.jetnotes.theme.JetNotesTheme
import com.raywenderlich.android.jetnotes.util.screens.NotesScreen
import com.raywenderlich.android.jetnotes.viewmodel.MainViewModel
import com.raywenderlich.android.jetnotes.viewmodel.MainViewModelFactory

/**
 * Main activity приложения.
 */

class MainActivity : AppCompatActivity() {

  private val viewModel: MainViewModel by viewModels(factoryProducer = {
    MainViewModelFactory(
      this,
      (application as JetNotesApplication).dependencyInjector.repository
    )
  })

  override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)

    setContent {
      JetNotesTheme {
        NotesScreen(viewModel = viewModel)
      }
    }
  }
}



