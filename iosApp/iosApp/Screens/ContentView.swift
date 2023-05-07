import SwiftUI
import SharedSDK

struct ContentView: View {
    
    private let vm = LoginViewModel()
    @State var email = ""
    @State var password = ""
    
    var body: some View {
        LoginScreen()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
