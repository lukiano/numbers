package com.lleggieri

import spire.algebra._
import spire.math._
import scala.annotation.tailrec

object Spire {

  implicit object NIsAdditiveMonoid extends NIsAdditiveMonoid

  trait NIsAdditiveMonoid extends AdditiveMonoid[N] {

    def plus(x: N, y: N) = x + y

    def zero = N.zero
  }

  implicit val monoid = NIsAdditiveMonoid.additive

  trait ConvertableFromN extends ConvertableFrom[N] {

    def toByte(a: N): Byte = a.toByte

    def toShort(a: N): Short = a.toShort

    def toInt(a: N): Int = a.toInt

    def toLong(a: N): Long = a.toLong

    def toFloat(a: N): Float = a.toFloat

    def toBigInt(a: N): BigInt = BigInt(a.v)

    def toBigDecimal(a: N): BigDecimal = BigDecimal(a.v)

    def toRational(a: N): Rational = Rational(a.v)

    def toNumber(a: N): Number = a.v

    def toType[B](a: N)(implicit convB: ConvertableTo[B]): B = convB.fromLong(a.v)

    def toString(a: N): String = a.toString

  }

  trait ConvertableToN extends ConvertableTo[N] {

    def fromByte(n: Byte): N = new N(n) with Final

    def fromShort(n: Short): N = new N(n) with Final

    def fromLong(n: Long): N = new N(n) with Final

    def fromFloat(n: Float): N = new N(n.toLong) with Final

    def fromDouble(n: Double): N = new N(n.toLong) with Final

    def fromBigInt(n: BigInt): N = new N(n.toLong) with Final

    def fromBigDecimal(n: BigDecimal): N = new N(n.toLong) with Final

    def fromRational(n: Rational): N = new N(n.toLong) with Final

    def fromType[B](b: B)(implicit convB: ConvertableFrom[B]): N = new N(convB.toLong(b)) with Final

  }

  trait NIsEuclideanRing extends EuclideanRing[N] {

    override def minus(a: N, b: N): N = a - b

    def negate(a: N): N = N.zero - a

    def one: N = N.one

    def plus(a: N, b: N): N = a + b

    def pow(a: N, b: N): N = {
      @tailrec def powAcum(acum: N, a: N, b: N): N =
        if (b == N.zero) acum else powAcum(acum * a, a, b - N.one)

      powAcum(N.one, a, b)
    }

    override def times(a: N, b: N): N = a * b

    def zero: N = N.zero

    override def fromInt(n: Int): N = new N(n) with Final

    def quot(a: N, b: N) = a / b

    def mod(a: N, b: N) = a % b

    def gcd(a: N, b: N): N = new N(spire.math.gcd(a.v, b.v)) with Final

  }

  trait NOrder extends Order[N] {
    override def eqv(x: N, y: N) = x == y

    override def neqv(x: N, y: N) = x != y

    override def gt(x: N, y: N) = x > y

    override def gteqv(x: N, y: N) = x >= y

    override def lt(x: N, y: N) = x < y

    override def lteqv(x: N, y: N) = x <= y

    def compare(x: N, y: N) = x.compare(y)
  }

  trait NIsSigned extends Signed[N] {
    def signum(a: N): Int = a.toInt

    def abs(a: N): N = if (a < N.zero) N.zero - a else a
  }


  trait NIsReal extends IsIntegral[N] with NOrder with NIsSigned {
    def toDouble(n: N): Double = n.toDouble
  }

  implicit object NIsIntegral extends Integral[N]
  with ConvertableFromN
  with ConvertableToN
  with NIsEuclideanRing
  with NIsReal

}
