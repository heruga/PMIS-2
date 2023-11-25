package pmis.chernyakova.pmis2_1.Entities.Book.data

import java.util.UUID

data class Book(
    val name: String,
    val id: UUID = UUID.randomUUID(),
    val author: String,
    val description: String,
    val image: Int,
    val hasRead: Boolean,
    val isFavorite: Boolean,
    val lastPage: Int
)