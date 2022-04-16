//
//  Video.swift
//  SwiftUI-List-Starter
//
//  Created by Sean Allen on 4/23/21.
//

import SwiftUI

struct Video : Identifiable {
    let id = UUID()
    let imageName: String
    let title: String
    let description: String
    let viewCount: Int
    let uploadDate: String
    let url: URL
}
