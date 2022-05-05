//
//  CoinsView.swift
//  Basic Application
//
//  Created by Alon Shlider on 11/07/2021.
//

import SwiftUI

struct UsersView: View {
    
    @ObservedObject private var usersViewModel = UserViewModel()
    
    var body: some View {
        VStack(alignment: .leading){
            
            let colors = [Color.blue, Color.green, Color.red]
                        
            List(usersViewModel.users) { user in
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
            usersViewModel.fetchUsers()
        }
    }
    
}

struct CoinsView_Previews: PreviewProvider {
    static var previews: some View {
        UsersView()
    }
}
