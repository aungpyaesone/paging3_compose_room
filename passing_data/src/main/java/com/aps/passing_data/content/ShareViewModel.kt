package com.aps.passing_data.content

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.aps.passing_data.ShareViewModel

@Composable
fun ShareViewModelSample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "onboarding") {
        navigation(
            startDestination = "personal_details",
            route = "onboarding"
        ) {
            composable(route = "personal_details") {entry->
                val viewModel = entry.shareViewModel<ShareViewModel>(navController = navController)
                val state by viewModel.shareState.collectAsStateWithLifecycle()

                PersonalDetailScreen(shareState = state) {
                    viewModel.updateState()
                    navController.navigate("terms_and_conditions")
                }

            }

            composable(route = "terms_and_conditions") { entry ->
                val viewModel = entry.shareViewModel<ShareViewModel>(navController = navController)
                val state by viewModel.shareState.collectAsStateWithLifecycle()

                TermAndConditionScreen(
                    shareState = state,
                    onBoardingScreenFinish = {
                        navController.navigate(route = "other_screen"){
                            popUpTo("onboarding"){
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(route = "other_screen"){
                OtherScreen()
            }

        }
    }
}

@Composable
fun PersonalDetailScreen(
    shareState: Int,
    onNavigate: () -> Unit
) {
    Button(onClick = onNavigate) {
        Text(text = "Personal Detail")
    }
}

@Composable
fun TermAndConditionScreen(
    shareState: Int,
    onBoardingScreenFinish : () -> Unit
) {
    Button(onClick = { onBoardingScreenFinish() }) {
        Text(text = "State : $shareState")
    }
}

@Composable
fun OtherScreen(){
 Text(text = "Hello World")
}

@Composable
inline fun <reified T:ViewModel> NavBackStackEntry.shareViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}