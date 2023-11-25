package pmis.chernyakova.pmis2_1.Entities.Book.ui

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.onConsumedWindowInsetsChanged
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pmis.chernyakova.pmis2_1.Entities.Book.data.Book
import pmis.chernyakova.pmis2_1.R


@Composable
fun BookItem(
    book: Book,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier,
    onEdit: () -> Unit
) {
    Card(
        modifier = modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(160.dp)
            .clickable { },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
    ) {
        Box(
            modifier = Modifiers
                .wrapContentSize()
                .padding(6.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    painter = painterResource(id = book.image),
                    contentDescription = null,
                    contentScale= ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(93.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        )


                )
                Box(
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .fillMaxSize()
                        .wrapContentSize()

                ) {
                    Column(modifier= Modifier
                        .padding(0.dp)
                        .fillMaxSize()
                        .padding(start = 10.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                        )
                    {
                        Column(modifier = Modifier.fillMaxWidth()
                            ,verticalArrangement = Arrangement.spacedBy(5.dp),
                            horizontalAlignment = Alignment.Start) {
                            Text(
                                text = book.name,
                                style = MaterialTheme.typography.titleLarge,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2
                            )

                            Text(
                                text = book.author,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "Last Page: "+ book.lastPage,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
//                        Column (verticalArrangement = Arrangement.spacedBy(5.dp)){
//                            Text(
//                                text = book.description,
//                                style = MaterialTheme.typography.titleMedium,
//                                overflow = TextOverflow.Ellipsis,
//                                maxLines = 3
//                            )
//
//                            Text(
//                                text = book.description,
//                                style = MaterialTheme.typography.titleMedium,
//                                overflow = TextOverflow.Ellipsis,
//                                maxLines = 3
//                            )
//                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Row(horizontalArrangement = Arrangement.spacedBy(5.dp),
                               ) {
                                IconButton(onClick = { /*TODO*/ },
                                    modifier=Modifier.padding(0.dp)) {

                                    Icon(modifier=Modifier.fillMaxSize(),
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null
                                    )
                                }
                                IconButton(onClick = { /*TODO*/ }) {

                                    Icon(
                                        modifier=Modifier.fillMaxSize(),
                                        imageVector = Icons.Default.FavoriteBorder,
                                        contentDescription = null
                                    )
                                }
                                IconButton(onClick = { onEdit(); }) {
                                    Icon(
                                        modifier=Modifier.fillMaxSize(),
                                        imageVector = Icons.Default.Create,
                                        contentDescription = null
                                    )
                                }
                            }
                            Row() {
                                IconButton(onClick = onRemove) {
                                    Icon(
                                        modifier=Modifier.fillMaxSize(),
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = null
                                    )
                                }
                            }

                        }






                    }
                }

            }
        }
    }
}

@Preview()
@Composable
fun previewBookItem() {
    BookItem(book = Book(author = "Xyi", name = "50 оттенков серого", description = "Nice d1ck", image = R.drawable.information, hasRead = false, isFavorite = true, lastPage = 10)
        , onRemove = { /*TODO*/ }, onEdit = {})
}