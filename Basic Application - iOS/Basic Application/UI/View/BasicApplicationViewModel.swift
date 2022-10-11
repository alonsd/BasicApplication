

import Foundation
import Combine

class BasicApplicationViewModel: ObservableObject {
    
//    @Inject
    var networkService : BasicApplicationNetworkService = BasicApplicationNetworkService()
        
    @Published var uiState = UiState()
    
    var cancellable : AnyCancellable?
    
    init(){
        fetchUsers()
    }
    
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
