package login

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginAction
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun LoginScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { LoginViewModel() }) { vm ->
        val state = vm.viewStates().observeAsState()
        val action = vm.viewActions().observeAsState()

        LoginView(state.value) {
            vm.obtainEvent(it)
        }

        when(action.value) {
            is LoginAction.OpenMainFlow -> {

            }

            is LoginAction.OpenRegistrationScreen -> rootController.push(
                NavigationTree.Auth.Register.name
            )

            is LoginAction.OpenForgotPasswordScreen -> rootController.push(
                NavigationTree.Auth.Forgot.name
            )

            null -> {}
        }
    }

}