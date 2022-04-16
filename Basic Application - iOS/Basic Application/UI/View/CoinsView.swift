//
//  CoinsView.swift
//  Basic Application
//
//  Created by Alon Shlider on 11/07/2021.
//

import SwiftUI

struct CoinsView: View {
    
    private let coinsViewModel = CoinViewModel()
    
    var body: some View {
        Text("CoinsView").onAppear {
            self.coinsViewModel.fetchCoins()
        }
    }
    
}

struct CoinsView_Previews: PreviewProvider {
    static var previews: some View {
        CoinsView()
    }
}
