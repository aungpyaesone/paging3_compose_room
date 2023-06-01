package com.aps.passing_data

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aps.passing_data.content.NavigationArgSample
import com.aps.passing_data.content.ShareViewModelSample
import com.aps.passing_data.content.StateFulDependencySample
import com.aps.passing_data.ui.theme.ComposePaging3CachingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePaging3CachingTheme {
            StateFulDependencySample()
        }
    }
}

}