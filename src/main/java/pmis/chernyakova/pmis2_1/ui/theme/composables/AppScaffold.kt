package pmis.chernyakova.pmis2_1.ui.theme.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.spec.Route
import pmis.chernyakova.pmis2_1.ui.theme.screen.appCurrentDestinationAsState
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.Destination
import pmis.chernyakova.pmis2_1.ui.theme.screen.startAppDestination


@OptIn(ExperimentalMaterialNavigationApi::class)
@SuppressLint("RestrictedApi", "SuspiciousIndentation")
@Composable
fun SampleScaffold(
    startRoute: Route,
    navController: NavHostController,
    topBar: @Composable (Destination, NavBackStackEntry?) -> Unit,
    snackbarHostState: SnackbarHostState,
    content: @Composable (PaddingValues) -> Unit,


) {
    val destination = navController.appCurrentDestinationAsState().value
        ?: startRoute.startAppDestination
    val navBackStackEntry = navController.currentBackStackEntry
        Scaffold(
            topBar = { topBar(destination, navBackStackEntry) },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },

                    content={
                Column(
                    modifier = Modifier.padding(it)
                ) {
                    content(it)
                }
            }
        )
}