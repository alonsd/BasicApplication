//
//  SwiftUI_List_StarterApp.swift
//  SwiftUI-List-Starter
//
//  Created by Sean Allen on 4/23/21.
//

import SwiftUI

@main
struct BasicApplication: App {
    
//    let persistenceController = BasicApplciationDatabase.instance

//    @Environment(\.scenePhase)
//    var scenePhase
    
    
    var body: some Scene {
        WindowGroup {
            CoinsView()
        }
//        .onChange(of: scenePhase) { newScenePhase in
//            switch newScenePhase {
//
//                case .background:
//                    print("Scene is background")
////                    persistenceController.save()
//                case .inactive:
//                    print("Scene is inactive")
//                case .active:
//                    print("Scene is active")
//                @unknown default:
//                    print("Scene is unknown default")
//            }
//        }
    }
}
