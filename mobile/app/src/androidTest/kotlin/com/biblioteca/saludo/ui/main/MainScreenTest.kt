package com.biblioteca.saludo.ui.main

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/** UI tests for [com.biblioteca.saludo.ui.main.MainScreen]. */
class MainScreenTest {

  @get:Rule val composeTestRule = createAndroidComposeRule<ComponentActivity>()

  @Before
  fun setup() {
    composeTestRule.setContent { MainScreen(listOf("Mundo")) }
  }

  @Test
  fun defaultGreeting_isShown() {
    composeTestRule.onNodeWithText("¡Hola, Mundo!").assertExists()
  }

  @Test
  fun typingName_updatesGreeting() {
    composeTestRule.onNodeWithText("Escribe tu nombre").performTextInput("Ana")
    composeTestRule.onNodeWithText("¡Hola, Ana!").assertExists()
  }
}
