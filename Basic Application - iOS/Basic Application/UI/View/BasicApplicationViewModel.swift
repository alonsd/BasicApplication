

import Foundation
import Combine

class BasicApplicationViewModel: ObservableObject {
    
    var networkService : BasicApplicationNetworkService
    
    init(networkService : BasicApplicationNetworkService){
        self.networkService = networkService
        fetchUsers()
    }
    
        
    @Published var uiState = UiState()
    
    var cancellable : AnyCancellable?
    
    func fetchUsers() {
        cancellable = networkService.fetchUsers().sink(receiveCompletion: { _ in }, receiveValue: { userResult in
            self.uiState.resetValues(state: UiState.State.data, userResponse: userResult)
        })
    }
    
    struct UiState{
        
        var state : State = State.initial
        var userResponse = UserResponse()
        var errorMessage = ""
        
        
        enum State {
            case data
            case error
            case initial
        }
        
        mutating func resetValues(
            state: State = State.initial,
            userResponse: UserResponse = UserResponse(),
            errorMessage : String = "") {
            self = UiState(state: state, userResponse: userResponse,errorMessage: errorMessage)
        }
    }
}
