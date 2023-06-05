@file:OptIn(ExperimentalComposeUiApi::class)

package com.aps.aly.presentation

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aps.aly.R
import com.aps.aly.data.Author
import com.aps.aly.data.BookX
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(top = 4.dp)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    stringResource(id = R.string.placeholder_search),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            },
            modifier = modifier
                .border(
                    BorderStroke(width = 1.dp, color = Color.Green),
                    shape = RoundedCornerShape(50)
                )
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(start = 8.dp)

        )
    }
}

//author: Author,


@Composable
fun AuthorSection(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Top Author",
                style = MaterialTheme.typography.bodySmall,
            )
            Text(
                text = "See All",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light
            )
        }

        content()

    }
}

@Composable
fun AuthorList(list: List<Author>, modifier: Modifier = Modifier) {
    LazyRow {
        items(
            items = list,
        ) {
            AuthorItem(author = it)
        }
    }
}

@Composable
fun AuthorItem(author: Author, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    ) {
        Image(
            painterResource(id = author.image), contentDescription = "null",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Text(
            text = author.name,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onBookClick: (BookX) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier.nestedScroll(rememberNestedScrollInteropConnection())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar()
        AuthorSection() {
            // AuthorList(list = authorViewModel._author)
        }
        Spacer(modifier = Modifier.height(16.dp))
        TabLayout(listOf(), onBookClick = onBookClick)

    }


}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(list: List<BookX>,onBookClick: (BookX) -> Unit) {
    val pagerState = rememberPagerState()
    Column {
      //  TabComposable(pagerState = pagerState,list)
        Spacer(modifier = Modifier.padding(top = 16.dp))
        TabComposable(pagerState = pagerState, bookList = list, onBookClick = onBookClick)
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabComposable(
    pagerState: PagerState,
    pages: Array<BookPages> = BookPages.values(),
    bookList: List<BookX>,
    onBookClick: (BookX) -> Unit
) {
    val list = listOf("For You", "Trending", "New Release")
    val scope = rememberCoroutineScope()

    TabRow(selectedTabIndex = pagerState.currentPage,
        modifier = Modifier.background(Color.Transparent),
    containerColor = Color.Transparent,
    indicator = {tapPosition ->
    }) {
        pages.forEachIndexed { index, page ->
            val title = stringResource(id = page.titleResId)
            Tab(
                selected = pagerState.currentPage == index,
                text = { Text(text = title, style = MaterialTheme.typography.bodySmall,
                    color = if (pagerState.currentPage == index) Color.Blue else Color.Gray,
                    fontWeight = if (pagerState.currentPage == index) FontWeight.SemiBold else FontWeight.Normal,
                )},
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
            )
        }

    }

    HorizontalPager(state = pagerState, pageCount = pages.size,
    verticalAlignment = Alignment.Top) {index ->
        when(pages[index]){
            BookPages.FOR_YOU ->{}
            BookPages.NEW_RELEASE -> {
            }
            else -> {}
        }
    }

}

@Composable
fun BookCard(modifier: Modifier = Modifier, book: BookX,onBookClick: (BookX) -> Unit) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .clickable {
                onBookClick(book)
            }
    ) {
//        Image(
//            painter = painterResource(id = book.img),
//            contentDescription = "books"
//        )
        Text(
            text = book.title, style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(text = book.title, style = MaterialTheme.typography.bodySmall)

    }
}


@Composable
fun BookCardList(modifier: Modifier = Modifier, bookList: List<BookX>,
                 onBookClick: (BookX) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier.fillMaxHeight(),
        contentPadding = PaddingValues(
            horizontal = 4.dp,
            vertical = 4.dp
        )
    ) {
        items(items = bookList,
        key = {it.id}) { book ->
            BookCard(modifier, book, onBookClick)
        }

    }
}

fun <T> LazyListScope.gridItems(
    data: List<T>,
    columnCount: Int,
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {

}

enum class BookPages(
    @StringRes val titleResId: Int
) {
    FOR_YOU(R.string.for_you),
    TRENDING(R.string.trending),
    NEW_RELEASE(R.string.new_release),
}

@Preview
@Composable
fun HomeScreenPreview(){
 HomeScreen(onBookClick = {})
}








