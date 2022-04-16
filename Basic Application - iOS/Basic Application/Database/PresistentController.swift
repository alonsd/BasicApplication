//
//  PresistentController.swift
//  Basic Application
//
//  Created by Alon Shlider on 06/06/2021.
//

import CoreData


struct BasicApplciationDatabase {
    
    static let instance = BasicApplciationDatabase()
    
    let container : NSPersistentContainer
    
    init() {
        container = NSPersistentContainer(name: "CoreDataDatabase")
        container.loadPersistentStores { NSEntityDescription, error in
            if let error = error {
                fatalError("Error: \(error.localizedDescription)")
            }
        }
    }
    
    func save(completion : @escaping(Error?) -> () = {_ in} ){
        let context = container.viewContext
        if context.hasChanges {
            do {
                try context.save()
                completion(nil)
            } catch {
                completion(error)
            }
        }
    }
    
    func delete(_ object: NSManagedObject, completion : @escaping(Error?) -> () = {_ in} ) {
        let context = container.viewContext
        context.delete(object)
        save(completion: completion)
    }
}


