

import SwiftUI
import Combine


struct BasicApplicationView: View {
    
    
    @Inject
    @ObservedObject var viewmodel : BasicApplicationViewModel
    
    var body: some View {
        
        switch(viewmodel.uiState.state) {
            case.initial: EmptyView()
                
            case.data:
                ViewDataState(userResponse: viewmodel.uiState.userResponse)
                
            case.error: EmptyView()
        }
    }
}



struct CoinsView_Previews: PreviewProvider {
    static var previews: some View {
        BasicApplicationView()
    }
}
