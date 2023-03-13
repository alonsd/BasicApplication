

import SwiftUI
import Combine


struct BasicApplicationView: View {
    
    @ObservedObject var viewmodel : BasicApplicationViewModel
    
    init(viewmodel : BasicApplicationViewModel){
        self.viewmodel = viewmodel
    }
    
    
    var body: some View {
        
        switch(viewmodel.uiState.state) {
            case.initial: EmptyView()
                
            case.data:
                ViewDataState(userResponse: viewmodel.uiState.userResponse)
                
            case.error: EmptyView()
        }
    }
}
