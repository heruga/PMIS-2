package pmis.chernyakova.pmis2_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import pmis.chernyakova.pmis2_1.ui.theme.Lab_0Theme
import pmis.chernyakova.pmis2_1.ui.theme.screen.About.AboutScreen
import pmis.chernyakova.pmis2_1.ui.theme.screen.Home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_0Theme{
                BookTrackerContent();
            }
        }
    }
}

