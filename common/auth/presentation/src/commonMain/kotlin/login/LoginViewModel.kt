package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState

class LoginViewModel: BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent> (
    initialState = LoginViewState(email = "", password = "")
) {

    private val authRepository: AuthRepository = Inject.instance()

    init {
        checkUserLoggedIn()
    }

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginClick -> sendLogin()
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.ForgotClick -> openForgot()
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is LoginEvent.RegistrationClick -> openRegistration()
            is LoginEvent.PasswordShowClick -> showPassword()
        }
    }

    private fun checkUserLoggedIn() {
        if(authRepository.isUserLoggedIn()) {
            viewAction = LoginAction.OpenMainFlow
        }
    }

    private fun openRegistration() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(
            email = value
        )
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(
            password = value
        )
    }

    private fun showPassword() {
        viewState = viewState.copy(isShowPassword = !viewState.isShowPassword)
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
        viewModelScope.launch {
            try {
                val response = authRepository.login(viewState.email, viewState.password)
                if (response.accessToken.isNotBlank()) {
                    viewState = viewState.copy(email = "", password = "", isSending = false)
                    viewAction = LoginAction.OpenMainFlow
                } else {
                    viewState = viewState.copy(isSending = false)
                }
            } catch (e: Exception) {
                viewState = viewState.copy(isSending = false)
            }
        }
    }
}