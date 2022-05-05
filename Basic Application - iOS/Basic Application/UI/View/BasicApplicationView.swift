

import SwiftUI
import CombineMoya

struct BasicApplicationView: View {
    
    @ObservedObject private var basicApplicationViewModel = BasicApplicationViewModel()
    
    var body: some View {
        VStack(alignment: .leading){
            
            let colors = [Color.blue, Color.green, Color.red]
                        
            List(basicApplicationViewModel.users) { user in
                Text(user.phone)
                    .font(.headline)
                    .foregroundColor(Color.white)
                    .frame(height: 55)
                    .frame(maxWidth: .infinity)
                    .background(colors.randomElement())
                    .cornerRadius(10)
                    .shadow(radius: 10)
                    .padding()
            }
        }
        .frame(minWidth: 0,
               maxWidth: .infinity,
               minHeight: 0,
               maxHeight: .infinity,
               alignment: .topLeading)
        .background(Color.red)
        .onAppear{
            basicApplicationViewModel.fetchUsers()
        }
    }
    
}

struct CoinsView_Previews: PreviewProvider {
    static var previews: some View {
        BasicApplicationView()
    }
}
