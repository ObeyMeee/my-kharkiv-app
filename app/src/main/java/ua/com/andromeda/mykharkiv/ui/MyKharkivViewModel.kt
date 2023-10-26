package ua.com.andromeda.mykharkiv.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyKharkivViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(MyKharkivUiState())
    val uiState: StateFlow<MyKharkivUiState> = _uiState


}