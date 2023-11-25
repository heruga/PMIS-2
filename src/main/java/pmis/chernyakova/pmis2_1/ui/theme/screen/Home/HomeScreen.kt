package pmis.chernyakova.pmis2_1.ui.theme.screen.Home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator.navigateUp
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.navigateTo
import com.ramcosta.composedestinations.navigation.popUpTo
import kotlinx.coroutines.delay
import pmis.chernyakova.pmis2_1.Entities.Book.data.Book
import pmis.chernyakova.pmis2_1.R
import pmis.chernyakova.pmis2_1.bottomBarHandler
import pmis.chernyakova.pmis2_1.ui.theme.screen.NavGraphs
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.EditBookScreenDestination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.HomeScreenDestination

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Destination
@RootNavGraph(start = true)
fun HomeScreen(navigator: NavController)
{
    val viewModel = viewModel<HomeScreenViewModel>()

    var addState = remember {
        mutableStateOf(false)
    }
    HomeScreenContent(
        items = viewModel.items,
        onAdd = {
            navigator.navigate(EditBookScreenDestination(), fun NavOptionsBuilder.() {
                launchSingleTop = true

                restoreState = true
                popUpTo(NavGraphs.root) {
                    saveState = true
                }
            })
            addState.value=true

        },
        onRemove = viewModel::onClickRemoveBook
    )
    val s=rememberBottomSheetScaffoldState()
    LaunchedEffect(addState.value) {
        s.snackbarHostState.showSnackbar("sssss")
    }
//    if(addState.value) {
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Snackbar(modifier = Modifier
//                .wrapContentSize()
//                .width(100.dp),
//                ) {
//                Text(text = "Book is added")
//            }
//        }
//
//    }

}