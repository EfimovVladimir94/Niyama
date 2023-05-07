//
//  LoginView.swift
//  iosApp
//
//  Created by Vladimir on 06.05.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginView: View {
    
    let viewState: LoginViewState
    let eventHandler: (LoginEvent) -> Void
    
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
                        eventHandler(.ForgotClick())
                    } label: {
                        Text("Забыли пароль?")
                            .foregroundColor(.gray)
                    }
                    .padding(.top, 15)
                }
                
                VStack(spacing: 0) {
                    Button {
                        eventHandler(.LoginClick())
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
                    eventHandler(.RegistrationClick())
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
                eventHandler(.EmailChanged(value: $0))
            })
            CstTextField(
                text: $password,
                title: "Пароль",
                placeholder: "Введите пароль"
            )
            .onChange(of: password, perform: {
                eventHandler(.PasswordChanged(value: $0))
            })
        }
    }
}
