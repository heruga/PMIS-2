package pmis.chernyakova.pmis2_1.ui.theme.composables


import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.utils.destination
import com.ramcosta.composedestinations.utils.navGraph
import pmis.chernyakova.pmis2_1.ui.theme.screen.Home.HomeScreen
import pmis.chernyakova.pmis2_1.ui.theme.screen.appCurrentDestinationAsState
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.AboutScreenDestination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.Destination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.EditBookScreenDestination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.HomeScreenDestination

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    destination: Destination,
    navBackStackEntry: NavBackStackEntry?,
) {
    TopAppBar(title = {Text(
        text = destination.topBarTitle(navBackStackEntry),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    )
    }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Destination.topBarTitle(navBackStackEntry: NavBackStackEntry?): String {
    return when (this) {
        HomeScreenDestination,
        AboutScreenDestination-> javaClass.simpleName.removeSuffix("Destination")

        EditBookScreenDestination -> "HomeScreen"
    }
}