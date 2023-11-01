package ua.com.andromeda.mykharkiv.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ua.com.andromeda.mykharkiv.data.model.Category
import ua.com.andromeda.mykharkiv.data.model.Place

class MyKharkivViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(MyKharkivUiState())
    val uiState: StateFlow<MyKharkivUiState> = _uiState

    fun updateCurrentPlace(place: Place) {
        _uiState.update {
            it.copy(currentPlace = place)
        }
    }

    fun updateCurrentCategory(category: Category) {
        _uiState.update {
            it.copy(currentCategory = category)
        }
    }
}