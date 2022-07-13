//
//  DiContainerWrapper.swift
//  Basic Application
//
//  Created by Alon Shlider on 14/05/2022.
//

import Foundation
import Swinject


//class DiContainerWrapper {
//
//    let sharedContainer : Container = Container()
//    static let shared = DiContainerWrapper()
//
//    required init() {
//        sharedContainer.register(BasicApplicationNetworkService.self) { _ in
//            return BasicApplicationNetworkService()
//        }
//        sharedContainer.register(BasicApplicationViewModel.self) { resolver in
//            let service = resolver.resolve(BasicApplicationNetworkService.self)!
//            let viewmodel = BasicApplicationViewModel(networkService: service)
//            return viewmodel
//        }
//        sharedContainer.register(BasicApplicationView.self) { resolver in
//            let viewmodel = resolver.resolve(BasicApplicationViewModel.self)!
//            return BasicApplicationView(viewmodel: viewmodel)
//
//        }
//    }
//}
