package pmis.chernyakova.pmis2_1

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import pmis.chernyakova.pmis2_1.ui.theme.Lab_0Theme
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavHostEngine
import com.ramcosta.composedestinations.utils.currentDestinationAsState
import pmis.chernyakova.pmis2_1.ui.theme.composables.SampleScaffold
import pmis.chernyakova.pmis2_1.ui.theme.composables.TopBar
import pmis.chernyakova.pmis2_1.ui.theme.screen.NavGraphs
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.AboutScreenDestination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.Destination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.DirectionDestination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.EditBookScreenDestination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.HomeScreenDestination


@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@Composable
fun BookTrackerContent() {
    val navHostEngine = rememberAnimatedNavHostEngine( // accompanist-navigation-material
        navHostContentAlignment = Alignment.Center,
    )
    val bottomSheetNavigator = rememberBottomSheetNavigator() // чтобы показать боттом-шиты
    val navController = rememberNavController().apply {
        navigatorProvider += bottomSheetNavigator
    }
    val currentDestination = navController.currentDestinationAsState() // <- из compose-destinations
    BottomBarDestinations.remove(AboutScreenDestination)
    val showBottomBar by remember { derivedStateOf { currentDestination.value in BottomBarDestinations } } // <- опционально - если в приложении есть боттом бар, настройте его согласно документации
    Lab_0Theme {
        val startRoute = NavGraphs.root.startRoute
        val snackbarHostState= remember{ SnackbarHostState ()}
        SampleScaffold(startRoute = startRoute,
            navController = navController,
            topBar = { dest, backStackEntry ->
            if (dest.shouldShowScaffoldElements) {
                TopBar(dest, backStackEntry)
            }
            },
            snackbarHostState = snackbarHostState) {
            BookTrackerNavigation(
                currentDestination = currentDestination,
                navigator = bottomSheetNavigator,
                engine = navHostEngine,
                navController = navController,
                showNavBar = showBottomBar,
            )
        }
    }
}
@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class)
@Composable
fun BookTrackerNavigation(currentDestination:State<DestinationSpec<*>?>,
                            navigator:BottomSheetNavigator,
                            engine:NavHostEngine,
                            navController: NavHostController,
                            showNavBar:Boolean) {
    ModalBottomSheetLayout(
        bottomSheetNavigator = navigator,
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                // try to avoid bottom sheet anchor bugs https://issuetracker.google.com/issues/178630869
                .sizeIn(minWidth = 1.dp, minHeight = 1.dp),
        ) {
            DestinationsNavHost(
                // настройка согласно вашей библиотеке
                modifier = Modifier.weight(1f),
                navGraph = NavGraphs.root,
                engine = engine,
                navController = navController,
                dependenciesContainerBuilder = { },
            )
            AnimatedVisibility(showNavBar) {

                BookNavigationBar(
                    onItemClick = navController.bottomBarHandler,
                    isSelected = { currentDestination.value == it.destination },
                )

            }
        }
    }
}
@Composable
fun BookNavigationBar(
    onItemClick: (NavigationBarItem) -> Unit,
    isSelected: (NavigationBarItem) -> Boolean,
    modifier: Modifier = Modifier,
    badge: (NavigationBarItem) -> Int? = { null },
) {
    NavigationBar(
        modifier = modifier,
    ) {
        NavigationBarItem.entries.forEach {
            NavigationBarItem(
                selected = isSelected(it),
                onClick = { onItemClick(it) },
                icon = { Icon(it.icon,contentDescription = null, tint= Color.White, modifier = Modifier.size(40.dp))}, // самостоятельно сделайте с помощью BadgedBox / Icon / Text
                label = { it.label },
                alwaysShowLabel = false, // ваше решение
            )
        }
    }
}


enum class NavigationBarItem(val icon: ImageVector, @StringRes val label: Int) { // у энамов могут быть параметры в котлине
    Home(Icons.Filled.Home, R.string.Home), // иконки можно найти в material-icons-extended
    About(Icons.Default.Info, R.string.About)
    // добавить как минимум два, остальное добавим позже Спасибо за отсутсвие желания учиться, Вайзин
}
internal val NavHostController.bottomBarHandler
    get() = { it: NavigationBarItem -> navigateTopLevel(it.destination) } // возвращает лямбду для навигации по менюшке
internal val NavController.bottomBarHandler
    get() = { it: NavigationBarItem -> navigateTopLevel(it.destination) }
@OptIn(ExperimentalAnimationApi::class)
internal fun NavController.navigateTopLevel(destination: DirectionDestination) = navigate(destination) {
    launchSingleTop = true // читаем доки чтобы понять что это, про бекстек
    restoreState = true
    popUpTo(NavGraphs.root) {
        saveState = true
    }
}
@OptIn(ExperimentalAnimationApi::class)
internal fun NavHostController.navigateTopLevel(destination: DirectionDestination) = navigate(destination) {
    launchSingleTop = true // читаем доки чтобы понять что это, про бекстек
    restoreState = true
    popUpTo(NavGraphs.root) {
        saveState = true
    }
}

internal val NavigationBarItem.destination: DirectionDestination
    get() = when (this) {
        NavigationBarItem.Home -> HomeScreenDestination
        NavigationBarItem.About -> AboutScreenDestination
    }

internal val BottomBarDestinations = NavigationBarItem.entries.map { it.destination }.toMutableSet()
private fun Collection<NavBackStackEntry>.print(prefix: String = "stack") {
    val stack = map { it.destination.route }.toTypedArray().contentToString()
    println("$prefix = $stack")
}



private val Destination.shouldShowScaffoldElements get() = this !is AboutScreenDestination