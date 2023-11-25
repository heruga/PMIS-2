package pmis.chernyakova.pmis2_1.ui.theme.screen.Home

import android.media.audiofx.DynamicsProcessing.Stage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pmis.chernyakova.pmis2_1.Entities.Book.data.Book
import pmis.chernyakova.pmis2_1.Entities.Book.ui.BookItem
import pmis.chernyakova.pmis2_1.R

@Composable
fun HomeScreenContent(
    items: MutableList<Book>,
    onRemove: (Book) -> Unit,
    onAdd: () -> Unit,
)
{
    LazyColumn(modifier=Modifier.padding(top=10.dp),
    contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy((10).dp) ){
        items(items, key = { it.id }){
                book->
            BookItem(book = book, onRemove = {onRemove(book)}, onEdit = {onAdd() })
        }

    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        FloatingActionButton(
            onClick = { onAdd()
                      items.add(Book(author = "Olga", name = "Я не хочу это делать", description = "Bruh", image = R.drawable.noimage, hasRead = false, isFavorite = false, lastPage = 5),
                      )}, modifier = Modifier.wrapContentSize().padding(end=5.dp, bottom = 5.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }

    if (items.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = "No books yet, pls add some",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }

    }

}
