package pmis.chernyakova.pmis2_1.ui.theme.screen.Edit

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.navigateTo
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.spec.DestinationStyle
import com.ramcosta.composedestinations.spec.DestinationStyleBottomSheet
import pmis.chernyakova.pmis2_1.ui.theme.screen.NavGraphs
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.HomeScreenDestination


@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterial3Api::class)
@ExperimentalAnimationApi
@Destination(style= DestinationStyleBottomSheet::class)
@Composable
fun EditBookScreen(navigator:NavController) {
    ModalBottomSheet(onDismissRequest = {
        navigator.navigate(HomeScreenDestination, fun NavOptionsBuilder.() {
            launchSingleTop = true
            restoreState = true
            popUpTo(NavGraphs.root)
            {

            }
        })
    },
        modifier = Modifier.wrapContentSize(),
        sheetState = SheetState(initialValue = SheetValue.Expanded, skipPartiallyExpanded = true)
    )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .animateContentSize()
            ) {
                Text(
                    text = "Edit Book",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    label = { Text("Title") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    label = { Text("Author") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    label = { Text("Genre") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        navigator.navigate(HomeScreenDestination, fun NavOptionsBuilder.() {
                            launchSingleTop = true

                            restoreState = true
                            popUpTo(NavGraphs.root)
                            {

                            }
                        })
                    },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = "Save",fontSize=20.sp)
                }
            }
        }

}