//
//  StandartButton.swift
//  SwiftUI-List-Starter
//
//  Created by Alon Shlider on 29/05/2021.
//

import SwiftUI

struct StandartButton: View {
    
    var title : String
    var body: some View {
        Text(title)
            .bold()
            .font(.title2)
            .frame(width: 200, height: 50)
            .background(Color(.systemRed))
            .foregroundColor(.white)
            .cornerRadius(10)
    }
}

struct StandartButton_Previews: PreviewProvider {
    static var previews: some View {
        StandartButton(title: "Watch Now")
    }
}
