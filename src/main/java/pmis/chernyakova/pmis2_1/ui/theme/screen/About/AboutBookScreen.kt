package pmis.chernyakova.pmis2_1.ui.theme.screen.About

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pmis.chernyakova.pmis2_1.NavigationBarItem
import pmis.chernyakova.pmis2_1.R
import pmis.chernyakova.pmis2_1.bottomBarHandler
import pmis.chernyakova.pmis2_1.ui.theme.Lab_0Theme
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.AboutScreenDestination
import pmis.chernyakova.pmis2_1.ui.theme.screen.destinations.HomeScreenDestination

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialNavigationApi::class,
    ExperimentalAnimationApi::class, ExperimentalAnimationApi::class
)
@Composable
@Destination
fun AboutScreen(navigator: DestinationsNavigator, navController:NavController)
{


    Lab_0Theme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.background,

                    ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = stringResource(id = R.string.version)
                    )
                }
            },
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,

                        ),
                    title = {

                        Text("About Ebooks",color=MaterialTheme.colorScheme.primary)
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.bottomBarHandler(NavigationBarItem.Home) }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
            },
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background,

            )
        {
                innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),


                ) {
                Column {


                    Image( modifier = Modifier
                        .size(90.dp)
                        .align(Alignment.CenterHorizontally),painter = painterResource(id = R.drawable.info), contentDescription = null)
                    Text(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                        textAlign = TextAlign.Center,
                        text = "Artwork by heruga", fontSize = 19.sp,
                        color=MaterialTheme.colorScheme.primary)
                    Text(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, top = 20.dp),
                        textAlign = TextAlign.Center,
                        text = "Our networks",fontSize = 19.sp,
                        color=MaterialTheme.colorScheme.primary)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    )
                    {
                        Image(
                            modifier = Modifier.size(50.dp).clickable {  },
                            painter = painterResource(id = R.drawable.webbrowser),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                        )
                        Image(
                            modifier = Modifier.size(50.dp).clickable {  },
                            painter = painterResource(id = R.drawable.telegram),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                        )
                        Image(
                            modifier = Modifier.size(50.dp).clickable {  },
                            painter = painterResource(id = R.drawable.instagram),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                        )
                    }
                    TextButton(onClick = { /*TODO*/ },) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.mail),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                            )
                            Column {
                                Text(text = "Email", fontSize = 16.sp)
                                Text(text = stringResource(R.string.email), fontSize = 14.sp)
                            }

                        }
                    }
                    TextButton(onClick = { /*TODO*/ },) {


                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.information),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                            )
                            Column {
                                Text(text = "FAQ", fontSize = 16.sp)
                                Text(text = stringResource(R.string.FAQ), fontSize = 14.sp)
                            }

                        }
                    }
                    TextButton(onClick = { /*TODO*/ },) {


                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.starrating),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                            )
                            Column {
                                Text(text = "Rate us", fontSize = 16.sp)
                                Text(text = stringResource(R.string.rate), fontSize = 14.sp)
                            }

                        }
                    }
                    TextButton(onClick = { /*TODO*/ },) {

                        Row(modifier = Modifier.fillMaxWidth()
                            .padding(end=30.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        )
                        {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(15.dp)

                            ) {
                                Image(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(id = R.drawable.statistics),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                                )
                                Column {
                                    Text(
                                        text = "Allow us to collect analytics",

                                        fontSize = 16.sp
                                    )
                                    Text(
                                        text = stringResource(R.string.analytics),

                                        fontSize = 14.sp
                                    )
                                }



                            }
                            var checked by remember { mutableStateOf(true) }

                            Switch(

                                checked = checked,
                                onCheckedChange = {
                                    checked = it
                                }
                            )
                        }

                    }

                }

            }
        }
    }
}