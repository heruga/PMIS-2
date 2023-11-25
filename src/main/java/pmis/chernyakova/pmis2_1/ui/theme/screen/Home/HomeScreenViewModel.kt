package pmis.chernyakova.pmis2_1.ui.theme.screen.Home

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import pmis.chernyakova.pmis2_1.R
import pmis.chernyakova.pmis2_1.Entities.Book.data.Book

class HomeScreenViewModel(): ViewModel (){
    val items: SnapshotStateList<Book> = DefaultBooks.toMutableStateList()

    fun onClickRemoveBook(book: Book) = items.remove(book)
    private companion object {

        private val DefaultBooks = listOf(
            Book(author = "Olga", name = "50 оттенков боли", description = "Nice", image = R.drawable.noimage, hasRead = false, isFavorite = true, lastPage = 10),
            Book(author = "Olga", name = "Уйма  страданий", description = "Nice", image = R.drawable.noimage, hasRead = false, isFavorite = true, lastPage = 10),
            Book(author = "Olga", name = "Я устал, Босс", description = "Bruh", image = R.drawable.noimage, hasRead = false, isFavorite = false, lastPage = 5),
        )
    }

}