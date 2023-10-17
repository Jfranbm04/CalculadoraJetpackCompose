package com.example.calculadoraversion016

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.BigDecimal
import java.util.*
import java.util.Stack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPrincipal()
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PantallaPrincipal() {

    // variable resultado
    var expresion = "0"
    var currentExpresion by remember { mutableStateOf(expresion) }


    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black),                 //La interfaz completa es negra, pero los row cambian el color
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(color = Color.Gray)
                .weight(1f),

            ){
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ){
                Resultado(numero = currentExpresion)
            }

        }

        // Separación entre los dos tipos de row
        Spacer(
            modifier = Modifier.height(25.dp)
        )



        // Operadores especiales
        Row(
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(color = Color.Gray)
                .weight(1f)
                .height(100.dp)
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(1.5f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion =""
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoOperadores("AC")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="/"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoOperadores("/")
            }


        }



        // Números y operadores

        Row(
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(color = Color.Gray)
                .weight(1f)
                .height(100.dp)
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="7"
                    },
                contentAlignment = Alignment.Center
            ){
                diseñoNumeros("7")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .fillMaxSize()
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="8"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoNumeros("8")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .fillMaxSize()
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="9"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoNumeros("9")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="+"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoOperadores("+")
            }


        }


        Row(
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(color = Color.Gray)
                .weight(1f)
                .height(100.dp)
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="4"
                    },
                contentAlignment = Alignment.Center
            ){
                diseñoNumeros("4")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .fillMaxSize()
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="5"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoNumeros("5")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .fillMaxSize()
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="6"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoNumeros("6")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="-"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoOperadores("-")
            }


        }

        Row(
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(color = Color.Gray)
                .weight(1f)
                .height(100.dp)
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="1"
                    },
                contentAlignment = Alignment.Center
            ){
                diseñoNumeros("1")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .fillMaxSize()
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="2"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoNumeros("2")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .fillMaxSize()
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="3"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoNumeros("3")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="*"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoOperadores("x")
            }


        }
        Row(
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(color = Color.Gray)
                .weight(1f)
                .height(100.dp)
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="."
                    },
                contentAlignment = Alignment.Center
            ){
                diseñoNumeros(",")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))        // Caja redondeada
                    .fillMaxSize()
                    .weight(0.5f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .clickable {
                        // Actualizar currentExpresion cuando se hace clic en el botón
                        currentExpresion +="0"
                    },
                contentAlignment = Alignment.Center
            )

            {
                diseñoNumeros("0")
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp)) // Caja redondeada
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
                    .clickable {
                        // Verificar si la expresión es válida antes de calcular
                        try {
                            val postfix = shuntingYard(currentExpresion)
                            val resultado = evaluarPostfix(postfix)
                            currentExpresion = resultado.toString()
                        } catch (e: Exception) {
                            // Manejar errores
                            currentExpresion = "Error"
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                diseñoOperadores("=")
            }
        }
    }
}

// Diseños botones
@Composable
fun diseñoNumeros(texto : String){
    Text(text = texto, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 40.sp,
        color = Color.Red)
}

@Composable
fun diseñoOperadores(texto : String) {
    Text(
        text = texto, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 40.sp,
        color = Color.Blue
    )
}

@Composable
fun Resultado(numero: String) {
    Text(
        text = numero, Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 40.sp,
            shadow = Shadow(
                color = Color.Blue,
                blurRadius = 3f
            )
        ),
        textAlign = TextAlign.End,
    )
}


fun shuntingYard(expresion: String): String {
    val output = StringBuilder()
    val operatorStack = Stack<Char>()
    val operators = setOf('+', '-', '*', '/')

    for (token in expresion) {
        if (token.isDigit()) {
            output.append(token)
        } else if (token in operators) {
            while (!operatorStack.isEmpty() && hasHigherPrecedence(token, operatorStack.peek())) {
                output.append(operatorStack.pop())
            }
            operatorStack.push(token)
        } else if (token == '(') {
            operatorStack.push(token)
        } else if (token == ')') {
            while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                output.append(operatorStack.pop())
            }
            if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                return "Expresión inválida"
            } else {
                operatorStack.pop()
            }
        }
    }

    while (!operatorStack.isEmpty()) {
        if (operatorStack.peek() == '(') {
            return "Expresión inválida"
        }
        output.append(operatorStack.pop())
    }

    return output.toString()
}

fun hasHigherPrecedence(op1: Char, op2: Char): Boolean {
    val precedence = mapOf('+' to 1, '-' to 1, '*' to 2, '/' to 2)
    return precedence[op1] ?: 0 >= precedence[op2] ?: 0
}

fun evaluarPostfix(expression: String): Double {
    val stack = Stack<Double>()

    for (token in expression) {
        if (token.isDigit()) {
            stack.push(token.toString().toDouble())
        } else {
            val operand2 = stack.pop()
            val operand1 = stack.pop()
            when (token) {
                '+' -> stack.push(operand1 + operand2)
                '-' -> stack.push(operand1 - operand2)
                '*' -> stack.push(operand1 * operand2)
                '/' -> stack.push(operand1 / operand2)
            }
        }
    }

    return stack.pop()
}