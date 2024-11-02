package com.vicki.simplecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vicki.simplecalculator.ui.theme.SimpleCalculatorTheme

class MainActivity : ComponentActivity() {


    var math = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SimpleCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier) {
                        var display by rememberSaveable { mutableStateOf("") }
                        var num1: Double? by rememberSaveable { mutableStateOf(null) }
                        var num2: Double? by rememberSaveable { mutableStateOf(null) }
                        var operation by rememberSaveable { mutableStateOf("") }
                        var answer: Double? by rememberSaveable { mutableStateOf(null) }

                        Text("This is a simple Calculator!")
                        Text(text = display.toString())
                        Text(text = answer.toString())

                        Row() {
                            Button(onClick = {
                                num1 = null
                                num2 = null
                                display = ""
                                answer = null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "back")
                            }
                            Button(onClick = { /*TODO*/ }, modifier = Modifier.size(80.dp)) {
                                Text(text = "+/-")
                            }
                            Button(onClick = { /*TODO*/ }, modifier = Modifier.size(80.dp)) {
                                Text(text = "%")
                            }
                            Button(onClick = {
                                operation = "/"
                                display = appendInput(display, "/")
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "/")
                            }
                        }
                        Row() {
                            Button(onClick = {
                                display = appendInput(display, "7")
                                num1 = if (num1 == null) 7.0 else num1
                                num2 = if (num1 != null) 7.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "7")
                            }
                            Button(onClick = {
                                display = appendInput(display, "8")
                                num1 = if (num1 == null) 8.0 else num1
                                num2 = if (num1 != null) 8.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "8")
                            }
                            Button(onClick = {
                                display = appendInput(display, "9")
                                num1 = if (num1 == null) 9.0 else num1
                                num2 = if (num1 != null) 9.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "9")
                            }
                            Button(onClick = {
                                operation = "*"
                                display = appendInput(display, "*")
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "*")
                            }
                        }
                        Row() {
                            Button(onClick = {
                                display = appendInput(display, "4")
                                num1 = if (num1 == null) 4.0 else num1
                                num2 = if (num1 != null) 4.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "4")
                            }
                            Button(onClick = {
                                display = appendInput(display, "5")
                                num1 = if (num1 == null) 5.0 else num1
                                num2 = if (num1 != null) 5.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "5")
                            }
                            Button(onClick = {
                                display = appendInput(display, "6")
                                num1 = if (num1 == null) 6.0 else num1
                                num2 = if (num1 != null) 6.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "6")
                            }
                            Button(onClick = {
                                operation = "-"
                                display = appendInput(display, "-")
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "-")
                            }
                        }
                        Row() {
                            Button(onClick = {
                                display = appendInput(display, "1")
                                num1 = if (num1 == null) 1.0 else num1
                                num2 = if (num1 != null) 1.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "1")
                            }
                            Button(onClick = {
                                display = appendInput(display, "2")
                                num1 = if (num1 == null) 2.0 else num1
                                num2 = if (num1 != null) 2.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "2")
                            }
                            Button(onClick = {
                                display = appendInput(display, "3")
                                num1 = if (num1 == null) 3.0 else num1
                                num2 = if (num1 != null) 3.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "3")
                            }
                            Button(onClick = {
                                operation = "+"
                                display = appendInput(display, "+")
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "+")
                            }
                        }
                        Row() {
                            Button(onClick = { /*TODO*/ }, modifier = Modifier.size(80.dp)) {
                                Text(text = "duck")
                            }
                            Button(onClick = {
                                display = appendInput(display, "0")
                                num1 = if (num1 == null) 0.0 else num1
                                num2 = if (num1 != null) 0.0 else null
                            }, modifier = Modifier.size(80.dp)) {
                                Text(text = "0")
                            }
                            Button(onClick = { /*TODO*/ }, modifier = Modifier.size(80.dp)) {
                                Text(text = ".")
                            }
                            Button(
                                onClick = { answer = calculate(num1, num2, operation) },
                                modifier = Modifier.size(80.dp)
                            ) {
                                Text(text = "=")
                            }
                        }

                    }

                }
            }
        }
    }
}


private fun appendInput(string: String, newString: String): String {
    return string + newString
}

private fun calculate(input1: Double?, input2: Double?, operator: String): Double? {
    val result = when (operator) {
        "+" -> input1?.plus(input2!!)
        "-" -> input1?.minus(input2!!)
        "*" -> input1?.times(input2!!)
        "/" -> input1?.div(input2!!)
        else -> 0.0
    }
    return result
}