//
// Autogenerated by Scrooge
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//
import Foundation
import TwitterApacheThrift
public class UnionStruct: ThriftCodable, Hashable {
    public var someUnion: MyUnion
    enum CodingKeys: Int, CodingKey {
        case someUnion = 1
    }
    public init(someUnion: MyUnion) {
        self.someUnion = someUnion
    }
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.someUnion)
    }
    public static func == (lhs: UnionStruct, rhs: UnionStruct) -> Bool {
        return lhs.someUnion == rhs.someUnion
    }
}
