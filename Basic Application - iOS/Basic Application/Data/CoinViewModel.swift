//
//  ViewModel.swift
//  Basic Application
//
//  Created by Alon Shlider on 11/07/2021.
//

import Foundation
import Combine

class CoinViewModel: ObservableObject {
    
    private let networkService = NetworkService()
    
//    @Published var coins = [Coin]()
    @Published var coins = String()
    
    var cancellable : AnyCancellable?
    
    init(){
        fetchCoins()
    }
    
    func fetchCoins() {
        print("bla bla")
        cancellable = networkService.fetchCoinsAsString().sink(receiveCompletion: { _ in
            print("inside completion")
        }, receiveValue: { coinsResult in
            self.coins = coinsResult
        })
    }
}
