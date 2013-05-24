package com.lleggieri

import scala.runtime.IntegralProxy
import scala.math.Integral

/**
 *
 * @param self because only an N can become rich.
 */
final class RichN(val self: N) extends IntegralProxy[N] {

  //All this stuff is adapted from RichLong
  protected def num = new Integral[N] {
    def plus(x: N, y: N) = x + y
    def minus(x: N, y: N) = x - y
    def times(x: N, y: N) = x * y
    def quot(x: N, y: N) = x / y
    def rem(x: N, y: N) = x % y
    def negate(x: N) = new N(-x.v) with Final
    def fromInt(x: Int) = new N(x) with Final
    def toInt(x: N) = x.v.toInt
    def toLong(x: N) = x.v
    def toN(x: N) = x
    def toFloat(x: N) = x.v
    def toDouble(x: N) = x.v
    def compare(x: N, y: N) = x.compare(y)
  }

  protected def ord = Ordering.ordered[N]

  override def isValidByte = self.v.toByte.toLong == self.v
  override def isValidShort = self.v.toShort.toLong == self.v
  override def isValidChar = self.v.toChar.toLong == self.v
  override def isValidInt = self.v.toInt.toLong == self.v

}

