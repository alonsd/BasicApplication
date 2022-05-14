

import SwiftUI
import Swinject

@main
struct BasicApplicationApp: App {
    
    let diContainerWrapper = DiContainerWrapper()
    
    var body: some Scene {
        
        WindowGroup {
            DiContainerWrapper.sharedContainer.resolve(BasicApplicationView.self)!
        }
    }
}
