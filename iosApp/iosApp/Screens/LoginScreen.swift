//
//  LoginScreen.swift
//  iosApp
//
//  Created by Vladimir on 06.05.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginScreen: View {
    @State private var isForgotPresented = false
    @State private var isRegistrationPresented = false
    @State private var isMainPresented = false
    private let loginViewModel = LoginViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(loginViewModel.viewStates())) { viewState in
            LoginView(viewState: viewState) { event in
                loginViewModel.obtainEvent(viewEvent: event)
            }
        }
        .onReceive(sharePublisher(loginViewModel.viewActions())) { action in
            switch action {
            case LoginAction.OpenForgotPasswordScreen():
                isForgotPresented.toggle()
            case LoginAction.OpenRegistrationScreen():
                isRegistrationPresented.toggle()
            case LoginAction.OpenMainFlow():
                isMainPresented.toggle()
            default:
                break
            }
        }
        .sheet(isPresented: $isForgotPresented) {
            ZStack {
                Color.blue.ignoresSafeArea()
            }
        }
        .sheet(isPresented: $isRegistrationPresented) {
            ZStack {
                Color.red.ignoresSafeArea()
            }
        }
        .sheet(isPresented: $isMainPresented) {
            ZStack {
                Color.green.ignoresSafeArea()
            }
        }
    }
}

struct LoginScreen_Previews: PreviewProvider {
    static var previews: some View {
        LoginScreen()
    }
}
