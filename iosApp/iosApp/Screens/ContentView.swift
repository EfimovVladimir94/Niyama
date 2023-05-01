import SwiftUI
import SharedSDK

struct ContentView: View {
    
    private let vm = LoginViewModel()
    @State var email = ""
    @State var password = ""
    
    var body: some View {
        ZStack {
            ZStack {
                Image("background")
                    .resizable()
                    .aspectRatio(contentMode: .fill)
                
            }
            .ignoresSafeArea()
            VStack(spacing: 0) {
                VStack {
                    Text("Авторизация")
                        .foregroundColor(.white)
                        .font(Font.title2)
                        .padding(.top, 12)
                    Image("logoAuth")
                        .resizable()
                        .frame(width: 190, height: 42)
                        .padding(.top, 56)
                    
                    credentialFields
                        .padding(.top, 46)
                    
                    Button {
                        vm.obtainEvent(viewEvent: .ForgotClick())
                    } label: {
                        Text("Забыли пароль?")
                            .foregroundColor(.gray)
                    }
                    .padding(.top, 15)
                }
                
                VStack(spacing: 0) {
                    Button {
                        vm.obtainEvent(viewEvent: .LoginClick())
                    } label: {
                        ZStack {
                            RoundedRectangle(cornerRadius: 20)
                                .foregroundColor(.orange)
                            Text("ВОЙТИ")
                                .foregroundColor(.white)
                        }
                    }
                    .frame(height: 40)
                    .padding(.top, 28)
                }
                .padding(.horizontal, 60)
                
                HStack(spacing: 13) {
                    Rectangle()
                        .frame(maxWidth: 30, maxHeight: 1)
                        .foregroundColor(Color.gray)
                    Text("или с помощью соц. сетей")
                        .font(.title3)
                        .foregroundColor(.gray)
                        .lineLimit(1)
                    Rectangle()
                        .frame(maxWidth: 30, maxHeight: 1)
                        .foregroundColor(Color.gray)
                }
                .padding(.top, 24)
                .padding(.horizontal, 34)
                
                HStack(spacing: 37) {
                    Image("facebookLogo")
                        .resizable()
                        .frame(width: 46, height: 46)
                    Image("google")
                        .resizable()
                        .frame(width: 46, height: 46)
                    Image("vk")
                        .resizable()
                        .frame(width: 46, height: 46)
                        
                }
                .padding(.top, 22)
                .padding(.horizontal, 81)
                
                Button {
                    vm.obtainEvent(viewEvent: .RegistrationClick())
                } label: {
                    Text("Регистрация")
                        .foregroundColor(.gray)
                }
                .padding(.top, 20)
                Spacer()
            }
        }
    }
    
    var credentialFields: some View {
        VStack(spacing: 36) {
            CstTextField(
                text: $email,
                title: "Email",
                placeholder: "Введите email"
            )
            .onChange(of: email, perform: {
                vm.obtainEvent(viewEvent: .EmailChanged(value: $0))
            })
            CstTextField(
                text: $password,
                title: "Пароль",
                placeholder: "Введите пароль"
            )
            .onChange(of: password, perform: {
                vm.obtainEvent(viewEvent: .PasswordChanged(value: $0))
            })
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
