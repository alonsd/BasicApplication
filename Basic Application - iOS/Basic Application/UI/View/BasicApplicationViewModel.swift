

import Foundation
import Combine

class BasicApplicationViewModel: ObservableObject {
    
    private let networkService = BasicApplicationNetworkService()
    
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
