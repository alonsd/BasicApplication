

import SwiftUI
import Swinject

@main
struct BasicApplicationApp: App {
    
    let resolver = Resolver()
    
    @Inject
    var statingView : BasicApplicationView
    
    var body: some Scene {

        WindowGroup {

            BasicApplicationView()
        }
    }
}
