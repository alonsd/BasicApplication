//
//  Coin.swift
//  Basic Application
//
//  Created by Alon Shlider on 11/07/2021.
//

import Foundation

// This file was generated from JSON Schema using quicktype, do not modify it directly.
// To parse the JSON, add this file to your project and do:
//
//   let coin = try? newJSONDecoder().decode(Coin.self, from: jsonData)

import Foundation

// MARK: - Coin
struct Coin: Codable {
    let status: String
    let data: DataClass
}

// MARK: - DataClass
struct DataClass: Codable {
    let stats: Stats
    let base: Base
    let coins: [CoinElement]
}

// MARK: - Base
struct Base: Codable {
    let symbol, sign: String
}

// MARK: - CoinElement
struct CoinElement: Codable {
    let id: Int
    let uuid, slug, symbol, name: String
    let coinDescription, color: String?
    let iconType: IconType
    let iconURL: String
    let websiteURL: String?
    let socials, links: [Link]
    let confirmedSupply: Bool
    let numberOfMarkets, numberOfExchanges: Int
    let type: CoinType
    let volume, marketCap: Int
    let price: String
    let circulatingSupply, totalSupply: Double?
    let approvedSupply: Bool
    let firstSeen, listedAt: Int
    let change: Double
    let rank: Int
    let history: [String]
    let allTimeHigh: AllTimeHigh
    let penalty: Bool

    enum CodingKeys: String, CodingKey {
        case id, uuid, slug, symbol, name
        case coinDescription
        case color, iconType
        case iconURL
        case websiteURL
        case socials, links, confirmedSupply, numberOfMarkets, numberOfExchanges, type, volume, marketCap, price, circulatingSupply, totalSupply, approvedSupply, firstSeen, listedAt, change, rank, history, allTimeHigh, penalty
    }
}

// MARK: - AllTimeHigh
struct AllTimeHigh: Codable {
    let price: String
    let timestamp: Int
}

enum IconType: String, Codable {
    case pixel = "pixel"
    case vector = "vector"
}

// MARK: - Link
struct Link: Codable {
    let name: String
    let type: LinkType
    let url: String
}

enum LinkType: String, Codable {
    case bitcointalk = "bitcointalk"
    case discord = "discord"
    case explorer = "explorer"
    case facebook = "facebook"
    case github = "github"
    case instagram = "instagram"
    case linkedin = "linkedin"
    case medium = "medium"
    case reddit = "reddit"
    case sinaWeibo = "sina-weibo"
    case telegram = "telegram"
    case twitter = "twitter"
    case vkontakte = "vkontakte"
    case website = "website"
    case wechat = "wechat"
    case youtube = "youtube"
}

enum CoinType: String, Codable {
    case coin = "coin"
}

// MARK: - Stats
struct Stats: Codable {
    let total, offset, limit: Int
    let order, base: String
    let totalMarkets, totalExchanges: Int
    let totalMarketCap, total24HVolume: Double

    enum CodingKeys: String, CodingKey {
        case total, offset, limit, order, base, totalMarkets, totalExchanges, totalMarketCap
        case total24HVolume
    }
}
