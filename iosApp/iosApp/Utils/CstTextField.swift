//
//  CstTextField.swift
//  iosApp
//
//  Created by Vladimir on 01.05.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct CstTextField: View {
    @Binding var text: String
    var title: String = ""
    var imageName: String = ""
    var placeholder: String = ""
    
    var body: some View {
        VStack(alignment: .leading, spacing: 12) {
            Text(title)
                .foregroundColor(.white)
            TextField("", text: $text)
                .autocapitalization(.none)
                .placeholder(when: text.isEmpty, placeholder: {
                    Text(placeholder)
                        .foregroundColor(.gray)
                })
                .accentColor(.blue)
                .foregroundColor(Color.white)
            Divider()
                .background(Color.white)
        }
        .padding(.horizontal, 35)
    }
}

struct CstTextField_Previews: PreviewProvider {
    static var previews: some View {
        CstTextField(
            text: .constant(""),
            title: "Email",
            imageName: "Search",
            placeholder: "Поиск..."
        )
    }
}

