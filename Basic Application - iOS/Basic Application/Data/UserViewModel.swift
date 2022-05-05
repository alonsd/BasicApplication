//
//  ViewModel.swift
//  Basic Application
//
//  Created by Alon Shlider on 11/07/2021.
//

import Foundation
import Combine

class UserViewModel: ObservableObject {
    
    private let networkService = NetworkService()
    
    @Published var users = UserResponse()
    
    var cancellable : AnyCancellable?
    
    init(){
        fetchUsers()
    }
    
    func fetchUsers() {
        print("bla bla")
        cancellable = networkService.fetchUsers().sink(receiveCompletion: { _ in
            print("inside completion")
        }, receiveValue: { userResult in
            self.users = userResult
        })
    }
}
