package com.lleggieri

//import language.implicitConversions
import language.postfixOps

/**
 * Class N from Number.
 * @param v the long number it represents.
 */
sealed abstract class N(val v: Long) extends Ordered[N] {

  override def equals(that: Any) = that match { //mimicking Value Classes
    case n: N => v == n.v
    case _ => false
  }

  override def hashCode() = if (v >= Int.MinValue && v <= Int.MaxValue) v.toInt else v.## //copied from ScalaNumericConversions

  override def toString = v.toString

  override def compare(that: N): Int = Ordering.Long.compare(v, that.v)

  def + (that: N): N with F = new N(v + that.v) with F
  def - (that: N): N with F = new N(v - that.v) with F
  def * (that: N): N with F = new N(v * that.v) with F
  def / (that: N): N with F = new N(v / that.v) with F
  def % (that: N): N with F = new N(v % that.v) with F

}

/**
 * HTM from Hundred, Thousand, Million. Adds these extensions to a Number.
 */
private[lleggieri] trait HTM { n: N =>

  def hundred(t: T): N with T = if (v < 100) new N(v * 100 + toValue(t)) with T else new N((v / 100) * 100 + (v % 100) * 100 + toValue(t)) with T
  def hundred(e: E): N with E = if (v < 100) new N(v * 100 + toValue(e)) with E else new N((v / 100) * 100 + (v % 100) * 100 + toValue(e)) with E

  def hundred(aux: Auxiliary): N with E = new N((this hundred).v * aux.multiplier) with E

  def hundred: N with E = if (v < 100) new N(v * 100) with E else new N((v / 100) * 100 + (v % 100) * 100) with E

  def thousand(t: T): N with T = if (v < 1000) new N(v * 1000 + toValue(t)) with T else new N((v / 1000) * 1000 + (v % 1000) * 1000 + toValue(t)) with T
  def thousand(e: E): N with E = if (v < 1000) new N(v * 1000 + toValue(e)) with E else new N((v / 1000) * 1000 + (v % 1000) * 1000 + toValue(e)) with E

  def thousand: N with E = if (v < 1000) new N(v * 1000) with E else new N((v / 1000) * 1000 + (v % 1000) * 1000) with E

  def million(t: T): N with T = new N(v * 1000000 + toValue(t)) with T
  def million(e: E): N with E = new N(v * 1000000 + toValue(e)) with E

  def million: N with E = new N(v * 1000000) with E

  private def toValue(t: T): Long = t.value
  private def toValue(e: E): Long = e.value

}

/**
 * F from Final. These Numbers cannot be used with thousand, hundred or million.
 */
private[lleggieri] trait F { n: N =>

}

/**
 * E from Extensible. These Numbers can be used with thousand, hundred or million.
 */
private[lleggieri] trait E extends HTM { n: N =>

  private[lleggieri] val value = n.v

}

/**
 * T from Tenth. These Numbers have methods to build Numbers from 21 to 99.
 */
private[lleggieri] trait T extends HTM { n: N =>

  def one: N = n + N.one
  def two: N = n + N.two
  def three: N = n + N.three
  def four: N = n + N.four
  def five: N = n + N.five
  def six: N = n + N.six
  def seven: N = n + N.seven
  def eight: N = n + N.eight
  def nine: N = n + N.nine

  private[lleggieri] val value = n.v

}

private[lleggieri] abstract sealed class Auxiliary(private[lleggieri] val multiplier: Long)
private[lleggieri] final class Thou extends Auxiliary(1000)
private[lleggieri] final class Mill extends Auxiliary(1000000)

object N {

  implicit def orderingE = new Ordering[N with E] { def compare(x: N with E, y: N with E) = x.compare(y) }
  implicit def orderingT = new Ordering[N with T] { def compare(x: N with T, y: N with T) = x.compare(y) }
  implicit def orderingF = new Ordering[N with F] { def compare(x: N with F, y: N with F) = x.compare(y) }

  /*
  @inline implicit def toLong(e: E): Long = e.asInstanceOf[N].v
  @inline implicit def toLong(t: T): Long = t.asInstanceOf[N].v
  @inline implicit def toLong(f: F): Long = f.asInstanceOf[N].v
  */

  val zero = new N(0) with F

  val one = new N(1) with E
  val two = new N(2) with E
  val three = new N(3) with E
  val four = new N(4) with E
  val five = new N(5) with E
  val six = new N(6) with E
  val seven = new N(7) with E
  val eight = new N(8) with E
  val nine = new N(9) with E

  val ten = new N(10) with E
  val eleven = new N(11) with E
  val twelve = new N(12) with E
  val thirteen = new N(13) with E
  val fourteen = new N(14) with E
  val fifteen = new N(15) with E
  val sixteen = new N(16) with E
  val seventeen = new N(17) with E
  val eighteen = new N(18) with E
  val nineteen = new N(19) with E

  val twenty = new N(20) with T
  val thirty = new N(30) with T
  val forty = new N(40) with T
  val fifty = new N(50) with T
  val sixty = new N(60) with T
  val seventy = new N(70) with T
  val eighty = new N(80) with T
  val ninety = new N(90) with T

  val thousand = new Thou
  val million = new Mill

}
