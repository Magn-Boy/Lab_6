package com.raywenderlich.android.jetnotes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import com.raywenderlich.android.jetnotes.viewmodel.MainViewModel
import com.raywenderlich.android.jetnotes.viewmodel.MainViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

/**
 * Main activity приложения.
 */

class MainActivity : AppCompatActivity() {

  private val viewModel: MainViewModel by viewModels(factoryProducer = {
    MainViewModelFactory(
      this,
      (application as NotesApplication).dependencyInjector.repository
    )
  })

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {

    }
  }
}
