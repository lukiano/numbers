package com.lleggieri

import spire.algebra.{ EuclideanRing, IsIntegral, NRoot, Order, Signed }

import spire.math.{NumberTag, BitString}

import scala.annotation.tailrec

trait NIsEuclideanRing extends EuclideanRing[N] {
  override def minus(a:N, b:N): N = a - b
  override def negate(a:N): N = zero - a
  override val one: N = N.one
  override def plus(a:N, b:N): N = a + b
  override def pow(a: N, b:Int): N = b match {
    case 0 => one
    case 1 => a
    case 2 => a * a
    case 3 => a * a * a
    case _ =>
      if (b > 0) {
        val e = b >> 1
        val c: N = if ((b & 1) == 1) a else one
        c * pow(a, e) * pow(a, e)
      } else {
        zero
      }
  }
  override def times(a:N, b:N): N = a * b
  override val zero: N = N.zero

  override def fromInt(n: Int): N = N.cons(n)

  override def quot(a:N, b:N) = a / b
  override def mod(a:N, b:N) = a % b
  override def gcd(a:N, b:N) = spire.math.gcd(a, b)(this)
}

// Not included in Instances trait!
trait NIsNRoot extends NRoot[N] {
  override def nroot(x: N, n: Int): N = {
    @tailrec def findnroot(prev: Long, add: Long): Long = {
      val next = prev | add
      val e = Math.pow(next, n)

      if (e == x.v || add == 0) {
        next
      } else if (e <= 0 || e > x.v) {
        findnroot(prev, add >> 1)
      } else {
        findnroot(next, add >> 1)
      }
    }

    if (n < 1) throw new IllegalArgumentException(s"nroot($n)")
    else if (n == 1) x
    else N.cons(findnroot(0, 1L << ((65 - n) / n)))
  }
  override def fpow(a:N, b:N): N = N.cons(spire.math.pow(a.v, b.v))
}

trait NOrder extends Order[N] {
  override def eqv(x:N, y:N) = x == y
  override def neqv(x:N, y:N) = x != y
  override def gt(x: N, y: N) = x > y
  override def gteqv(x: N, y: N) = x >= y
  override def lt(x: N, y: N) = x < y
  override def lteqv(x: N, y: N) = x <= y
  def compare(x: N, y: N) = if (x < y) -1 else if (x == y) 0 else 1
}

trait NIsSigned extends Signed[N] {
  def signum(a: N): Int = java.lang.Long.signum(a.v)
  def abs(a: N): N = if (a < N.zero) N.zero - a else a
}

trait NIsReal extends IsIntegral[N] with NOrder with NIsSigned {
  def toDouble(n: N): Double = n.v.toDouble
}

@SerialVersionUID(0L)
class NIsBitString extends BitString[N] with Serializable {
  override val one: N = N.cons(-1)
  override val zero: N = N.zero
  override def and(a: N, b: N): N = N.cons(a.v & b.v)
  override def or(a: N, b: N): N = N.cons(a.v | b.v)
  override def complement(a: N): N = N.cons(~a.v)
  override def xor(a: N, b: N): N = N.cons(a.v ^ b.v)

  override def signed: Boolean = true
  override def width: Int = 64
  override def toHexString(n: N): String = java.lang.Long.toHexString(n.v)

  override def bitCount(n: N): Int = java.lang.Long.bitCount(n.v)
  override def highestOneBit(n: N): N = N.cons(java.lang.Long.highestOneBit(n.v))
  override def lowestOneBit(n: N): N = N.cons(java.lang.Long.lowestOneBit(n.v))
  override def numberOfLeadingZeros(n: N): Int = java.lang.Long.numberOfLeadingZeros(n.v)
  override def numberOfTrailingZeros(n: N): Int = java.lang.Long.numberOfTrailingZeros(n.v)

  override def leftShift(n: N, i: Int): N = N.cons(n.v << i)
  override def rightShift(n: N, i: Int): N = N.cons(n.v >> i)
  override def signedRightShift(n: N, i: Int): N = N.cons(n.v >>> i)
  override def rotateLeft(n: N, i: Int): N = N.cons(java.lang.Long.rotateLeft(n.v, i))
  override def rotateRight(n: N, i: Int): N = N.cons(java.lang.Long.rotateRight(n.v, i))
}

@SerialVersionUID(0L)
class NAlgebra extends NIsEuclideanRing with NIsNRoot with NIsReal with Serializable

trait NInstances {
  implicit final val NBitString = new NIsBitString
  implicit final val NAlgebra = new NAlgebra
  implicit final val NTag: NumberTag[N] = new NumberTag.BuiltinIntTag[N](N.zero, N.MinValue, N.MaxValue)
}

object spireN extends NInstances

