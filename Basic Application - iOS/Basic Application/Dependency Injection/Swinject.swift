////
////  Extensions.swift
////  Basic Application
////
////  Created by Alon Shlider on 14/05/2022.
////
//
//import Foundation
//import Swinject
//
//
//@propertyWrapper
//struct Inject<Component> {
//    let wrappedValue: Component
//    init() {
//        self.wrappedValue = Resolver.shared.resolve(Component.self)
//    }
//}
//
//class Resolver {
//    static let shared = Resolver()
//    private var container = buildContainer()
//    
//    func resolve<T>(_ type: T.Type) -> T {
//        container.resolve(T.self)!
//    }
//}
//
//func buildContainer() -> Swinject.Container {
//    
//    let container = Swinject.Container()
//    container.register(BasicApplicationNetworkService.self) { _ in
//        return BasicApplicationNetworkService()
//    }
//    container.register(BasicApplicationViewModel.self) { _ in
//        return BasicApplicationViewModel()
//    }
//    container.register(BasicApplicationView.self) { resolver in
//    
//        return BasicApplicationView()
//    }
//
//    return container
//    
//}
