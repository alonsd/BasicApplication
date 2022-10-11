//
//  ViewModel.swift
//  Basic Application
//
//  Created by Alon Shlider on 11/07/2021.
//

import Foundation
import Combine


class BasicApplicationNetworkService {
    
    private var urlComponents : URLComponents {
        var components = URLComponents()
        components.scheme = "https"
        components.host = "jsonplaceholder.typicode.com"
        components.path = "/users"
        return components
    }
        
    func fetchUsersAsString() -> AnyPublisher<String, Error> {
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
    
    func fetchUsers() -> AnyPublisher<UserResponse, Error> {
        return URLSession.shared.dataTaskPublisher(for: urlComponents.url!)
            .map {$0.data}
            .decode(type: UserResponse.self, decoder: JSONDecoder())
            .receive(on: DispatchQueue.main)
            .eraseToAnyPublisher()
    }
    
    

}
