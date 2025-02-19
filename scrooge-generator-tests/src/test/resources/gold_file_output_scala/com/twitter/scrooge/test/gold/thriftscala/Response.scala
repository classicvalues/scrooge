/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.io.Buf
import com.twitter.scrooge.{
  InvalidFieldsException,
  LazyTProtocol,
  StructBuilder,
  StructBuilderFactory,
  TFieldBlob,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructField,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ValidatingThriftStruct,
  ValidatingThriftStructCodec3
}
import com.twitter.scrooge.adapt.{AccessRecorder, AdaptTProtocol, Decoder}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.TMemoryBuffer
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.reflect.{ClassTag, classTag}


object Response extends ValidatingThriftStructCodec3[Response] with StructBuilderFactory[Response] {
  val Struct: TStruct = new TStruct("Response")
  val StatusCodeField: TField = new TField("statusCode", TType.I32, 1)
  val StatusCodeFieldManifest: Manifest[Int] = manifest[Int]
  val ResponseUnionField: TField = new TField("responseUnion", TType.STRUCT, 2)
  val ResponseUnionFieldManifest: Manifest[com.twitter.scrooge.test.gold.thriftscala.ResponseUnion] = manifest[com.twitter.scrooge.test.gold.thriftscala.ResponseUnion]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      StatusCodeField,
      false,
      false,
      StatusCodeFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None,
      _root_.scala.Option(0)
    ),
    new ThriftStructFieldInfo(
      ResponseUnionField,
      false,
      false,
      ResponseUnionFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None,
      _root_.scala.Option(com.twitter.scrooge.test.gold.thriftscala.ResponseUnion.unsafeEmpty)
    )
  )


  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map[String, String](
        ("com.twitter.scrooge.scala.generateStructProxy", "true")
    )

  private val fieldTypes: IndexedSeq[ClassTag[_]] = IndexedSeq[ClassTag[_]](
    classTag[Int].asInstanceOf[ClassTag[_]],
    classTag[com.twitter.scrooge.test.gold.thriftscala.ResponseUnion].asInstanceOf[ClassTag[_]]
  )

  private[this] val structFields: Seq[ThriftStructField[Response]] = Seq[ThriftStructField[Response]](
    new ThriftStructField[Response](
      StatusCodeField,
      _root_.scala.Some(StatusCodeFieldManifest),
      classOf[Response]) {
        def getValue[R](struct: Response): R = struct.statusCode.asInstanceOf[R]
    },
    new ThriftStructField[Response](
      ResponseUnionField,
      _root_.scala.Some(ResponseUnionFieldManifest),
      classOf[Response]) {
        def getValue[R](struct: Response): R = struct.responseUnion.asInstanceOf[R]
    }
  )

  override lazy val metaData: ThriftStructMetaData[Response] =
    ThriftStructMetaData(this, structFields, fieldInfos, Nil, structAnnotations)

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: Response): Unit = {
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: Response): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    buf ++= validateField(item.statusCode)
    buf ++= validateField(item.responseUnion)
    buf.toList
  }

  /**
   * Validate that all validation annotations on the struct meet the criteria defined in the
   * corresponding [[com.twitter.scrooge.validation.ThriftConstraintValidator]].
   */
  def validateInstanceValue(item: Response): Set[com.twitter.scrooge.thrift_validation.ThriftValidationViolation] = {
    val violations = scala.collection.mutable.Set.empty[com.twitter.scrooge.thrift_validation.ThriftValidationViolation]
    violations ++= validateFieldValue("statusCode", item.statusCode, fieldInfos.apply(0).fieldAnnotations, scala.None)
    violations ++= validateFieldValue("responseUnion", item.responseUnion, fieldInfos.apply(1).fieldAnnotations, scala.None)
    violations.toSet
  }

  def withoutPassthroughFields(original: Response): Response =
    new Immutable(
      statusCode = original.statusCode,
      responseUnion =
        {
          val field = original.responseUnion
          com.twitter.scrooge.test.gold.thriftscala.ResponseUnion.withoutPassthroughFields(field)
        }
    )

  lazy val unsafeEmpty: Response = {
    val statusCode: Int = 0
    val responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = com.twitter.scrooge.test.gold.thriftscala.ResponseUnion.unsafeEmpty

    new Immutable(
      statusCode,
      responseUnion,
      _root_.com.twitter.scrooge.internal.TProtocols.NoPassthroughFields
    )
  }

  def newBuilder(): StructBuilder[Response] = new ResponseStructBuilder(_root_.scala.None, fieldTypes)

  override def encode(_item: Response, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  @volatile private[this] var adaptiveDecoder: Decoder[Response] = _

  private[this] val accessRecordingDecoderBuilder: AccessRecorder => Decoder[Response] = { accessRecorder =>
    new Decoder[Response] {
      def apply(prot: AdaptTProtocol): Response = new AccessRecordingWrapper(decodeInternal(prot, true), accessRecorder)
    }
  }
  private[this] val fallbackDecoder = new Decoder[Response] {
    def apply(prot: AdaptTProtocol): Response = decodeInternal(prot, true)
  }
  private[this] def adaptiveDecode(_iprot: AdaptTProtocol): Response = {
    val adaptContext = _iprot.adaptContext
    val reloadRequired = adaptContext.shouldReloadDecoder
    synchronized {
      if ((adaptiveDecoder eq null) || reloadRequired) {
        adaptiveDecoder = adaptContext.buildDecoder(this, fallbackDecoder, accessRecordingDecoderBuilder)
      }
    }
    adaptiveDecoder(_iprot)
  }

  /**
   * AccessRecordingWrapper keeps track of fields that are accessed while
   * delegating to underlying struct.
   */
  private[this] class AccessRecordingWrapper(underlying: Response, accessRecorder: AccessRecorder) extends Response {
    override def statusCode: Int = {
      accessRecorder.fieldAccessed(1)
      underlying.statusCode
    }
    override def responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = {
      accessRecorder.fieldAccessed(2)
      underlying.responseUnion
    }
    override def write(_oprot: TProtocol): Unit = underlying.write(_oprot)

    override def _passthroughFields: immutable$Map[Short, TFieldBlob] = underlying._passthroughFields
  }

  override def decode(_iprot: TProtocol): Response = {
    if (_iprot.isInstanceOf[LazyTProtocol]) {
      decodeInternal(_iprot, true)
    } else if (_iprot.isInstanceOf[AdaptTProtocol]) {
      adaptiveDecode(_iprot.asInstanceOf[AdaptTProtocol])
    } else {
      decodeInternal(_iprot, false)
    }
  }

  private[thriftscala] def eagerDecode(_iprot: TProtocol): Response = {
    decodeInternal(_iprot, false)
  }

  private[this] def decodeInternal(_iprot: TProtocol, lazily: Boolean): Response = {
    var statusCode: Int = 0
    var responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = null

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = if (lazily) _iprot.asInstanceOf[LazyTProtocol].offset else -1

    _iprot.readStructBegin()
    do {
      val _field = _iprot.readFieldBegin()
      val _fieldType = _field.`type`
      if (_fieldType == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _root_.com.twitter.scrooge.internal.TProtocols.validateFieldType(TType.I32, _fieldType, "statusCode")
            statusCode = _iprot.readI32()
          case 2 =>
            _root_.com.twitter.scrooge.internal.TProtocols.validateFieldType(TType.STRUCT, _fieldType, "responseUnion")
            responseUnion = com.twitter.scrooge.test.gold.thriftscala.ResponseUnion.decode(_iprot)
          case _ =>
            _passthroughFields = _root_.com.twitter.scrooge.internal.TProtocols.readPassthroughField(_iprot, _field, _passthroughFields)
        }
        _iprot.readFieldEnd()
      }
    } while (!_done)
    _iprot.readStructEnd()


    val _passthroughFieldsResult =
      if (_passthroughFields eq null) _root_.com.twitter.scrooge.internal.TProtocols.NoPassthroughFields
      else _passthroughFields.result()
    if (lazily) {
      val _lazyProt = _iprot.asInstanceOf[LazyTProtocol]
      new LazyImmutable(
        _lazyProt,
        _lazyProt.buffer,
        _start_offset,
        _lazyProt.offset,
        statusCode,
        responseUnion,
        _passthroughFieldsResult
      )
    } else {
      new Immutable(
        statusCode,
        responseUnion,
        _passthroughFieldsResult
      )
    }
  }

  def apply(
    statusCode: Int,
    responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion
  ): Response =
    new Immutable(
      statusCode,
      responseUnion
    )

  def unapply(_item: Response): _root_.scala.Option[_root_.scala.Tuple2[Int, com.twitter.scrooge.test.gold.thriftscala.ResponseUnion]] = _root_.scala.Some(_item.toTuple)



  object Immutable extends ThriftStructCodec3[Response] {
    override def encode(_item: Response, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): Response = Response.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[Response] = Response.metaData
  }

  /**
   * The default read-only implementation of Response.  You typically should not need to
   * directly reference this class; instead, use the Response.apply method to construct
   * new instances.
   */
  class Immutable(
      val statusCode: Int,
      val responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Response {
    def this(
      statusCode: Int,
      responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion
    ) = this(
      statusCode,
      responseUnion,
      immutable$Map.empty[Short, TFieldBlob]
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      val statusCode: Int,
      val responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Response {

    override def write(_oprot: TProtocol): Unit = {
      if (_oprot.isInstanceOf[LazyTProtocol]) {
        _oprot.asInstanceOf[LazyTProtocol].writeRaw(_buf, _start_offset, _end_offset - _start_offset)
      } else {
        super.write(_oprot)
      }
    }


    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode: Int = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the Response trait with additional state or
   * behavior and implement the read-only methods from Response using an underlying
   * instance.
   */
  trait Proxy extends Response {
    protected def _underlying_Response: Response
    override def statusCode: Int = _underlying_Response.statusCode
    override def responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = _underlying_Response.responseUnion
    override def _passthroughFields: immutable$Map[Short, TFieldBlob] = _underlying_Response._passthroughFields
  }
}

/**
 * Prefer the companion object's [[com.twitter.scrooge.test.gold.thriftscala.Response.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait Response
  extends ThriftStruct
  with _root_.scala.Product2[Int, com.twitter.scrooge.test.gold.thriftscala.ResponseUnion]
  with ValidatingThriftStruct[Response]
  with java.io.Serializable
{
  import Response._

  def statusCode: Int
  def responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1: Int = statusCode
  def _2: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = responseUnion

  def toTuple: _root_.scala.Tuple2[Int, com.twitter.scrooge.test.gold.thriftscala.ResponseUnion] =
    _root_.scala.Tuple2[Int, com.twitter.scrooge.test.gold.thriftscala.ResponseUnion](
      statusCode,
      responseUnion
    )


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    val passedthroughValue = _passthroughFields.get(_fieldId)
    if (passedthroughValue.isDefined) {
      passedthroughValue
    } else {
      val _buff = new TMemoryBuffer(32)
      val _oprot = new TCompactProtocol(_buff)

      val _fieldOpt: _root_.scala.Option[TField] = _fieldId match {
        case 1 =>
            _oprot.writeI32(statusCode)
            _root_.scala.Some(Response.StatusCodeField)
        case 2 =>
          if (responseUnion ne null) {
            responseUnion.write(_oprot)
            _root_.scala.Some(Response.ResponseUnionField)
          } else {
            _root_.scala.None
          }
        case _ => _root_.scala.None
      }
      if (_fieldOpt.isDefined) {
        _root_.scala.Some(TFieldBlob(_fieldOpt.get, Buf.ByteArray.Owned(_buff.getArray)))
      } else {
        _root_.scala.None
      }
    }
  }


  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids.flatMap { id => getFieldBlob(id).map { fieldBlob => (id, fieldBlob) } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): Response = {
    var statusCode: Int = this.statusCode
    var responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = this.responseUnion
    var _passthroughFields = this._passthroughFields
    val _iprot = _blob.read 
    _blob.id match {
      case 1 =>
        statusCode = _iprot.readI32()
      case 2 =>
        responseUnion = com.twitter.scrooge.test.gold.thriftscala.ResponseUnion.decode(_iprot)
      case _ => _passthroughFields += _root_.scala.Tuple2(_blob.id, _blob)
    }
    new Immutable(
      statusCode,
      responseUnion,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): Response = {
    var statusCode: Int = this.statusCode
    var responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = this.responseUnion

    _fieldId match {
      case 1 =>
        statusCode = 0
      case 2 =>
        responseUnion = null
      case _ =>
    }
    new Immutable(
      statusCode,
      responseUnion,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetStatusCode: Response = unsetField(1)

  def unsetResponseUnion: Response = unsetField(2)


  override def write(_oprot: TProtocol): Unit = {
    Response.validate(this)
    _oprot.writeStructBegin(Struct)
    _oprot.writeFieldBegin(StatusCodeField)
    _oprot.writeI32(statusCode)
    _oprot.writeFieldEnd()
    if (responseUnion ne null) {
      _oprot.writeFieldBegin(ResponseUnionField)
      responseUnion.write(_oprot)
      _oprot.writeFieldEnd()
    }
    _root_.com.twitter.scrooge.internal.TProtocols.finishWritingStruct(_oprot, _passthroughFields)
  }

  def copy(
    statusCode: Int = this.statusCode,
    responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = this.responseUnion,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): Response =
    new Immutable(
      statusCode,
      responseUnion,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Response]

  private[this] def _equals(other: Response): Boolean =
      this.productArity == other.productArity &&
      this.productIterator.sameElements(other.productIterator) &&
      this._passthroughFields == other._passthroughFields

  override def equals(other: Any): Boolean =
    canEqual(other) && _equals(other.asInstanceOf[Response])

  override def hashCode: Int = {
    _root_.scala.runtime.ScalaRunTime._hashCode(this)
  }

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)

  override def productPrefix: String = "Response"

  def _codec: ValidatingThriftStructCodec3[Response] = Response

  def newBuilder(): StructBuilder[Response] = new ResponseStructBuilder(_root_.scala.Some(this), fieldTypes)
}

private[thriftscala] class ResponseStructBuilder(instance: _root_.scala.Option[Response], fieldTypes: IndexedSeq[ClassTag[_]])
    extends StructBuilder[Response](fieldTypes) {

  def build(): Response = {
    val _fieldArray = fieldArray // shadow variable
    if (instance.isDefined) {
      val instanceValue = instance.get
      Response(
        if (_fieldArray(0) == null) instanceValue.statusCode else _fieldArray(0).asInstanceOf[Int],
        if (_fieldArray(1) == null) instanceValue.responseUnion else _fieldArray(1).asInstanceOf[com.twitter.scrooge.test.gold.thriftscala.ResponseUnion]
      )
    } else {
      if (genericArrayOps(_fieldArray).contains(null)) throw new InvalidFieldsException(structBuildError("Response"))
      Response(
        _fieldArray(0).asInstanceOf[Int],
        _fieldArray(1).asInstanceOf[com.twitter.scrooge.test.gold.thriftscala.ResponseUnion]
      )
    }
  }
}

private class Response__AdaptDecoder {

  def decode(_iprot: AdaptTProtocol): Response = {
    import Response._
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    val adapt = new Response__Adapt(
      _iprot,
      _iprot.buffer,
      _start_offset)

    AdaptTProtocol.usedStartMarker(1)
    var statusCode: Int = 0
    AdaptTProtocol.usedEndMarker(1)

    AdaptTProtocol.usedStartMarker(2)
    var responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = null
    AdaptTProtocol.usedEndMarker(2)

    _iprot.readStructBegin()
    do {
      val _field = _iprot.readFieldBegin()
      val _fieldType = _field.`type`
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 => {
            if (_fieldType == TType.I32) {
              AdaptTProtocol.usedStartMarker(1)
              statusCode = _iprot.readI32()
              AdaptTProtocol.usedEndMarker(1)
              AdaptTProtocol.unusedStartMarker(1)
              _iprot.offsetSkipI32()
              AdaptTProtocol.unusedEndMarker(1)
            } else {
              throw AdaptTProtocol.unexpectedTypeException(
                TType.I32,
                _fieldType,
                "statusCode"
              )
            }
            AdaptTProtocol.usedStartMarker(1)
            adapt.set_statusCode(statusCode)
            AdaptTProtocol.usedEndMarker(1)
          }
          case 2 => {
            if (_fieldType == TType.STRUCT) {
              AdaptTProtocol.usedStartMarker(2)
              responseUnion = com.twitter.scrooge.test.gold.thriftscala.ResponseUnion.decode(_iprot)
              AdaptTProtocol.usedEndMarker(2)
              AdaptTProtocol.unusedStartMarker(2)
              _iprot.offsetSkipStruct()
              AdaptTProtocol.unusedEndMarker(2)
            } else {
              throw AdaptTProtocol.unexpectedTypeException(
                TType.STRUCT,
                _fieldType,
                "responseUnion"
              )
            }
            AdaptTProtocol.usedStartMarker(2)
            adapt.set_responseUnion(responseUnion)
            AdaptTProtocol.usedEndMarker(2)
          }
          case _ =>
            if (_passthroughFields eq null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += _root_.scala.Tuple2(_field.id, TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    } while (!_done)
    _iprot.readStructEnd()

    adapt.set__endOffset(_iprot.offset)
    if (_passthroughFields ne null) {
      adapt.set__passthroughFields(_passthroughFields.result())
    }
    adapt
  }
}

/**
 * This is the base template for Adaptive decoding. This class gets pruned and
 * reloaded at runtime.
 */
private class Response__Adapt(
    _proto: AdaptTProtocol,
    _buf: Array[Byte],
    _start_offset: Int) extends Response {

  /**
   * In case any unexpected field is accessed, fallback to eager decoding.
   */
  private[this] lazy val delegate: Response = {
    val bytes = _root_.java.util.Arrays.copyOfRange(_buf, _start_offset, _end_offset)
    val proto = _proto.withBytes(bytes)
    Response.eagerDecode(proto)
  }

  private[this] var m_statusCode: Int = _
  def set_statusCode(statusCode: Int): Unit = m_statusCode = statusCode
  // This will be removed by ASM if field is unused.
  def statusCode: Int = m_statusCode
  // This will be removed by ASM if field is used otherwise renamed to statusCode.
  def delegated_statusCode: Int = delegate.statusCode

  private[this] var m_responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = _
  def set_responseUnion(responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion): Unit = m_responseUnion = responseUnion
  // This will be removed by ASM if field is unused.
  def responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = m_responseUnion
  // This will be removed by ASM if field is used otherwise renamed to responseUnion.
  def delegated_responseUnion: com.twitter.scrooge.test.gold.thriftscala.ResponseUnion = delegate.responseUnion


  private[this] var _end_offset: Int = _
  def set__endOffset(offset: Int): Unit = _end_offset = offset

  private[this] var __passthroughFields: immutable$Map[Short, TFieldBlob] = _root_.com.twitter.scrooge.internal.TProtocols.NoPassthroughFields
  def set__passthroughFields(passthroughFields: immutable$Map[Short, TFieldBlob]): Unit =
    __passthroughFields = passthroughFields

  override def _passthroughFields: immutable$Map[Short, TFieldBlob] = __passthroughFields

  /*
  Override the super hash code to make it a lazy val rather than def.

  Calculating the hash code can be expensive, caching it where possible
  can provide significant performance wins. (Key in a hash map for instance)
  Usually not safe since the normal constructor will accept a mutable map or
  set as an arg
  Here however we control how the class is generated from serialized data.
  With the class private and the contract that we throw away our mutable references
  having the hash code lazy here is safe.
  */
  override lazy val hashCode: Int = super.hashCode

  override def write(_oprot: TProtocol): Unit = {
    if (_oprot.isInstanceOf[AdaptTProtocol]) {
      _oprot.asInstanceOf[AdaptTProtocol].writeRaw(_buf, _start_offset, _end_offset - _start_offset)
    } else {
      super.write(_oprot)
    }
  }
}
