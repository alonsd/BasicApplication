//
//  ManualDI.swift
//  Basic Application
//
//  Created by Alon Shlider on 01/03/2023.
//

import Foundation

class Container {
    
    static let shared = Container()
    private var didRegisterDepenencies = false
    var factoryDictionary : [String : () -> Any] = [:]
    
    static func registerAll(){
        if shared.didRegisterDepenencies { return }
        shared.didRegisterDepenencies = true
        shared.register(type: BasicApplicationView.self, {
            BasicApplicationView(viewmodel: shared.resolve(BasicApplicationViewModel.self)!)
        })
        shared.register(type: BasicApplicationViewModel.self, {
            BasicApplicationViewModel(networkService: shared.resolve(BasicApplicationNetworkService.self)!)
        })
        shared.register(type: BasicApplicationNetworkService.self, {
            BasicApplicationNetworkService()
        })
    }
    
    
    func register<Service>(type: Service.Type, _ factory: @escaping () -> Service) {
        factoryDictionary[String(describing: type.self)] = factory
    }
    
    func resolve<Service>(_ type: Service.Type) -> Service? {
        return factoryDictionary[String(describing: type.self)]?() as? Service
    }
    
}


@propertyWrapper
struct InjectManual<Type> {
    var type : Type
    
    init (){
        Container.registerAll()
        self.type = Container.shared.resolve(Type.self)!
    }
    
    var wrappedValue: Type {
        get {
            return self.type
        }
        mutating set {
            self.type = newValue
        }
    }
}
