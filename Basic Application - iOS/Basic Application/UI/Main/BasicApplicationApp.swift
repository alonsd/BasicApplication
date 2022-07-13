

import SwiftUI
import Swinject

@main
struct BasicApplicationApp: App {
    
//    let diContainerWrapper = DiContainerWrapper()
    let resolver = Resolver()
    
    @Inject
    var statingView : BasicApplicationView
    
    var body: some Scene {

        WindowGroup {
//            DiContainerWrapper.shared.sharedContainer.resolve(BasicApplicationView.self)!
            statingView
        }
    }
}
