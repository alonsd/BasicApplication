//
//  CoinsView.swift
//  Basic Application
//
//  Created by Alon Shlider on 11/07/2021.
//

import SwiftUI

struct CoinsView: View {
    
    @ObservedObject private var coinsViewModel = CoinViewModel()
    
    var body: some View {
        List(coinsViewModel.coins, id: \.self) { coin in
            Text(coin.name + " - " + coin.email)
        }.onAppear{
            coinsViewModel.fetchCoins()
        }
    }
    
}

struct CoinsView_Previews: PreviewProvider {
    static var previews: some View {
        CoinsView()
    }
}
