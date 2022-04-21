//
//  ViewModel.swift
//  Basic Application
//
//  Created by Alon Shlider on 11/07/2021.
//

import Foundation
import Combine

class NetworkService: ObservableObject {
    
    private var urlComponents : URLComponents {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "jsonplaceholder.typicode.com"
        components.path = "/users"
        return components
    }
    
    var cancelablle : AnyCancellable?
    
    func fetchCoinsAsString() -> AnyPublisher<Any, Error> {
        return URLSession.shared.dataTaskPublisher(for: urlComponents.url!)
            .tryMap { dataTaskPublisher -> String in
                guard let string = String(data: dataTaskPublisher.data, encoding: .utf8) else {
                    throw URLError(.badServerResponse)
                }
                return string
            }
            .receive(on: DispatchQueue.main)
            .eraseToAnyPublisher()
    }
    
    func fetchCoins() -> AnyPublisher<Any, Error> {
        return URLSession.shared.dataTaskPublisher(for: urlComponents.url!)
            .tryMap { dataTaskPublisher -> String in
                guard let string = String(data: dataTaskPublisher.data, encoding: .utf8) else {
                    throw URLError(.badServerResponse)
                }
                return string
            }
//            .decode(type: [Coin].self, decoder: JSONDecoder())
            .receive(on: DispatchQueue.main)
            .eraseToAnyPublisher()
    }
}
