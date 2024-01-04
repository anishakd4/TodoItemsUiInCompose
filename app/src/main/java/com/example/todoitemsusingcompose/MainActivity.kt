package com.example.todoitemsusingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoitemsusingcompose.composables.TodoInputBar
import com.example.todoitemsusingcompose.composables.TodoItemsContainer
import com.example.todoitemsusingcompose.data.TodoItem
import com.example.todoitemsusingcompose.ui.constants.OverlappingHeight
import com.example.todoitemsusingcompose.ui.theme.TodoItemsUsingComposeTheme
import kotlinx.coroutines.flow.flowOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                TodoItemsContainer(
                    // 1. Mock Data for Todo Items
                    todoItemsFlow = flowOf(
                        listOf(
                            TodoItem(title = "Todo Item 1"),
                            TodoItem(title = "Todo Item 2", isDone = true),
                            TodoItem(title = "Todo Item 3"),
                            TodoItem(title = "Todo Item 4", isDone = true),
                            TodoItem(title = "Todo Item 5"),
                            TodoItem(title = "Todo Item 6"),
                            TodoItem(title = "Todo Item 7"),
                            TodoItem(title = "Todo Item 8"),
                            TodoItem(title = "Todo Item 9"),
                            TodoItem(title = "Todo Item 10"),
                            TodoItem(title = "Todo Item 11", isDone = true),
                            TodoItem(title = "Todo Item 12"),
                            TodoItem(title = "Todo Item 13"),
                            TodoItem(title = "Todo Item 14"),
                            TodoItem(title = "Todo Item 15")
                        )
                    ),
                    onItemClick = {},
                    onItemDelete = {},
                    // 2. Space Adjustment for Overlapping UI Elements
                    overlappingElementsHeight = OverlappingHeight
                )
                TodoInputBar(
                    modifier = Modifier.align(Alignment.BottomStart),
                    onAddButtonClick = {}
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoItemsUsingComposeTheme {
        Greeting("Android")
    }
}