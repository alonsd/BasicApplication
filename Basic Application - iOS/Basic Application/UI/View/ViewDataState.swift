//
//  ViewDataState.swift
//  Basic Application
//
//  Created by Alon Shlider on 05/10/2022.
//

import Foundation
import SwiftUI

struct ViewDataState : View {
    
    let userResponse: UserResponse
    
    var body : some View {
        VStack(alignment: .leading){
            
            let colors = [Color.blue, Color.green, Color.red]
                        
            List(userResponse) { user in
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
    }
}
