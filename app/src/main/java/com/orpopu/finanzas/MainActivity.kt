package com.orpopu.finanzas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.orpopu.finanzas.ui.navigation.FinanzasNavigation
import com.orpopu.finanzas.ui.theme.FinanzasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanzasTheme {
                Surface(modifier = Modifier, color = MaterialTheme.colorScheme.background) {
                    FinanzasNavigation()
                }
            }
        }
    }
}
