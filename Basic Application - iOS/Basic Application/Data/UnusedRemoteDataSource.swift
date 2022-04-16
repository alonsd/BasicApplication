//
//  RemoteDataSource.swift
//  Basic Application
//
//  Created by Alon Shlider on 30/05/2021.
//
//
//import Foundation
//
//
//// IMPLEMENT date decoding strategy https://stevenpcurtis.medium.com/swifts-jsondecoder-s-one-big-miss-59974f0026a3
//
//protocol ServerResponseModel {
//    associatedtype T
//
//    var code: Int { get }
//    var message: String { get }
//    var data: T? { get }
//}
//
//enum HTTPMethod: String {
//    case get = "GET"
//    case post = "POST"
//    case put = "PUT"
//    case patch = "PATCH"
//    case delete = "DELETE"
//}
//
//protocol NetworkingService {
//    func request<T: Decodable & ServerResponseModel>(url: URL, method: HTTPMethod, headers: [String: String]?, queryItems: [URLQueryItem]?, body: [String: Any]?, completion: @escaping (URLResponse?, Result<T, Error>) -> ())
//
//    var handleCustomErrors: ((_ statusCode: Int, _ message: String) -> Error)? { get set }
//}
//
//extension NetworkingService {
//    func request<T: Decodable & ServerResponseModel>(url: URL, method: HTTPMethod, headers: [String: String]? = nil, queryItems: [URLQueryItem]? = nil, body: [String: Any]? = nil, completion: @escaping (URLResponse?, Result<T, Error>) -> ()) {
//        request(url: url, method: method, headers: headers, queryItems: queryItems, body: body, completion: completion)
//    }
//}
//
//
//class Networking: NetworkingService {
//
//    private let urlSession = URLSession.shared
//    var handleCustomErrors: ((_ statusCode: Int, _ message: String) -> Error)?
//
//
//    func request<T: Decodable & ServerResponseModel>(url: URL, method: HTTPMethod, headers: [String: String]? = nil, queryItems: [URLQueryItem]? = nil, body: [String: Any]? = nil, completion: @escaping (URLResponse?, Result<T, Error>) -> ()) {
//        guard var urlComponents = URLComponents(url: url, resolvingAgainstBaseURL: true) else {
//            completion(nil, .failure(IMError(title: "Invalid endpoint", description: "Invalid endpoint", code: -1)))
//            return
//        }
//
//        urlComponents.queryItems = queryItems
//
//        guard let url = urlComponents.url else {
//            completion(nil, .failure(IMError(title: "Invalid endpoint", description: "Invalid endpoint", code: -1)))
//            return
//        }
//
//        var request = URLRequest(url: url)
//        request.httpMethod = method.rawValue
//
//        if let headers = headers {
//            request.allHTTPHeaderFields = headers
//        }
//
//        if let body = body {
//            do {
//                request.httpBody = try JSONSerialization.data(withJSONObject: body, options: .prettyPrinted)
//                if let data = request.httpBody {
//                    print(String(data: data, encoding: .utf8) ?? "")
//                }
//            } catch {
//                print(error.localizedDescription)
//            }
//        }
//
//        urlSession.dataTask(with: request) { result in
//            switch result {
//                case .success(let (response, data)):
//                    self.printData(with: data)
//                    do {
//                        let values = try JSONDecoder().decode(T.self, from: data)
//                        guard let statusCode = (response as? HTTPURLResponse)?.statusCode, 200..<299 ~= statusCode else {
//                            if let customError = self.handleCustomErrors {
//                                completion(response, .failure(customError((response as? HTTPURLResponse)?.statusCode ?? values.code, values.message)))
//                            } else {
//                                completion(response, .failure(IMError(title: values.message, description: values.message, code: values.code)))
//                            }
//                            return
//                        }
//
//                        completion(response, .success(values))
//                    } catch {
//                        print("Decoded JSON error: \(error)")
//                        completion(response, .failure(IMError(title: "Error when decoding json", description: "Error when decoding json", code: -3)))
//                    }
//
//                case .failure(let error):
//                    completion(nil, .failure(IMError(title: error.localizedDescription, description: error.localizedDescription, code: -4)))
//            }
//        }.resume()
//    }
//
//    private func printData(with data: Data) {
//        guard let string = String(data: data, encoding: .utf8) else { return }
//        print(string)
//    }
//}
//
//
//// MARK: - Extension
//
//extension URLSession {
//
//    func dataTask(with urlRequest: URLRequest, result: @escaping (Result<(URLResponse, Data), Error>) -> Void) -> URLSessionDataTask {
//        return dataTask(with: urlRequest) { (data, response, error) in
//            if let error = error {
//                result(.failure(error))
//                return
//            }
//
//            guard let response = response, let data = data else {
//                let error = NSError(domain: "error", code: 0, userInfo: nil)
//                result(.failure(error))
//                return
//            }
//
//            result(.success((response, data)))
//        }
//    }
//
//}
//
//extension Data {
//
//    var jsonPretty: NSString? {
//        guard let object = try? JSONSerialization.jsonObject(with: self, options: []),
//              let data = try? JSONSerialization.data(withJSONObject: object, options: [.prettyPrinted]),
//              let prettyPrintedString = NSString(data: data, encoding: String.Encoding.utf8.rawValue) else { return nil }
//
//        return prettyPrintedString
//    }
//
//}
