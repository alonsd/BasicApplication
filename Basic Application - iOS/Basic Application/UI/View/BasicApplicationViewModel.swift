

import Foundation
import Combine

class BasicApplicationViewModel: ObservableObject {
    
    let networkService : BasicApplicationNetworkService
        
    @Published var users = UserResponse()
    
    var cancellable : AnyCancellable?
    
    init(networkService : BasicApplicationNetworkService){
        self.networkService = networkService
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
