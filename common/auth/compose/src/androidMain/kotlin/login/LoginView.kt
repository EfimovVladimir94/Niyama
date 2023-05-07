package login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.niyama.android.auth.compose.R
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme

@Composable
fun LoginView(
    state: LoginViewState,
    eventHandler: (LoginEvent) -> Unit)
{
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Text("Авторизация",
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 12.dp),
                    color = Theme.colors.primaryTextColor,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(56.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(70.dp))
            TextField(
                value = state.email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 33.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Unspecified,
                    textColor = Color.White
                ),
                onValueChange = { eventHandler.invoke(LoginEvent.EmailChanged(it)) },
                placeholder = { Text("EMAIL") }
            )
            TextField(
                value = state.password,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 33.dp)
                    .padding(top = 47.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Unspecified,
                    textColor = Color.White
                ),
                visualTransformation = if(state.isShowPassword) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                onValueChange = { eventHandler.invoke(LoginEvent.PasswordChanged(it)) },
                placeholder = { Text("ПАРОЛЬ") },
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            eventHandler.invoke(LoginEvent.PasswordShowClick)
                        },
                        imageVector = if (state.isShowPassword) {
                            Icons.Outlined.Clear
                        } else {
                            Icons.Outlined.Lock
                        },
                        contentDescription = "Password hidden",
                        tint = Color.White
                    )
                }
            )
            Text("Забыли пароль?",
                modifier = Modifier
                    .padding(top = 15.dp)
                    .clickable {
                        eventHandler.invoke(LoginEvent.ForgotClick)
                    },
                color = Theme.colors.primaryTextColor,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 33.dp)
                .padding(top = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Theme.colors.primaryAction
                ),
                shape = RoundedCornerShape(20.dp),
                onClick = { eventHandler.invoke(LoginEvent.LoginClick) },
                content = {
                    Text("ВОЙТИ")
                }
            )
            Text("или с помощью соц. сетей",
                modifier = Modifier
                    .padding(top = 24.dp),
                color = Theme.colors.secondaryTextColor,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}