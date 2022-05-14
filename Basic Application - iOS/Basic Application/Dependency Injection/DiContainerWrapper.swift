//
//  DiContainerWrapper.swift
//  Basic Application
//
//  Created by Alon Shlider on 14/05/2022.
//

import Foundation
import Swinject


class DiContainerWrapper {
    
    static let sharedContainer : Container = Container()
    
    required init() {
        DiContainerWrapper.sharedContainer.register(BasicApplicationNetworkService.self) { _ in
            return BasicApplicationNetworkService()
        }
        DiContainerWrapper.sharedContainer.register(BasicApplicationViewModel.self) { resolver in
            let service = resolver.resolve(BasicApplicationNetworkService.self)!
            let viewmodel = BasicApplicationViewModel(networkService: service)
            return viewmodel
        }
        DiContainerWrapper.sharedContainer.register(BasicApplicationView.self) { resolver in
            let viewmodel = resolver.resolve(BasicApplicationViewModel.self)!
            return BasicApplicationView(viewmodel: viewmodel)
            
        }
    }
}
