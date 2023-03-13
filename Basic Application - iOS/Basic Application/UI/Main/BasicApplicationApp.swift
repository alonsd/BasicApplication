

import SwiftUI
import Swinject

@main
struct BasicApplicationApp: App {
    
    @InjectManual
    var statingView : BasicApplicationView
    
    var body: some Scene {

        WindowGroup {
            statingView
        }
    }
}
