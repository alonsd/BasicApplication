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
    
    @Published var data = String()
    
    var cancellable : AnyCancellable?
    
    func fetchCoins() {
        print("bla bla")
        cancellable = networkService.fetchCoins().sink(receiveCompletion: { _ in
            print("inside receive completion")
        }, receiveValue: { value in
            print("received value - \(value)")
        })
    }
}
