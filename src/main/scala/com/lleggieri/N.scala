package com.lleggieri

import language.implicitConversions
import language.postfixOps

/**
 * Class N from Number.
 * @param v the long number it represents.
 */
abstract class N private[lleggieri] (val v: Long) extends OrderedN {

  //mimicking Value Classes
  override def equals(that: Any) = that match {
    case n: N => v == n.v
    case _ => false
  }

  //copied from ScalaNumericConversions
  override def hashCode() = if (v >= Int.MinValue && v <= Int.MaxValue) v.toInt else v.##

  override def toString = v.toString

}

/**
 * The companion class were all constants are defined
 */
object N {

  /*
   Ordered[N] deals with sorting a mix of numbers, and these implicits deals when all the values to be sorted
   belong to a particular subclass (really, classes with a particular trait).
   */
  implicit val orderingE = new Ordering[N with Extensible] { def compare(x: N with Extensible, y: N with Extensible) = x.compare(y) }
  implicit val orderingT = new Ordering[N with Tenth] { def compare(x: N with Tenth, y: N with Tenth) = x.compare(y) }
  implicit val orderingF = new Ordering[N with Final] { def compare(x: N with Final, y: N with Final) = x.compare(y) }

  /*
  @inline implicit def toLong(e: E): Long = e.asInstanceOf[N].v
  @inline implicit def toLong(t: T): Long = t.asInstanceOf[N].v
  @inline implicit def toLong(f: F): Long = f.asInstanceOf[N].v
  */

  val zero = cons(0)

  val one = new N(1) with Extensible
  val two = new N(2) with Extensible
  val three = new N(3) with Extensible
  val four = new N(4) with Extensible
  val five = new N(5) with Extensible
  val six = new N(6) with Extensible
  val seven = new N(7) with Extensible
  val eight = new N(8) with Extensible
  val nine = new N(9) with Extensible

  val ten = new N(10) with Extensible
  val eleven = new N(11) with Extensible
  val twelve = new N(12) with Extensible
  val thirteen = new N(13) with Extensible
  val fourteen = new N(14) with Extensible
  val fifteen = new N(15) with Extensible
  val sixteen = new N(16) with Extensible
  val seventeen = new N(17) with Extensible
  val eighteen = new N(18) with Extensible
  val nineteen = new N(19) with Extensible

  val twenty = new N(20) with Tenth
  val thirty = new N(30) with Tenth
  val forty = new N(40) with Tenth
  val fifty = new N(50) with Tenth
  val sixty = new N(60) with Tenth
  val seventy = new N(70) with Tenth
  val eighty = new N(80) with Tenth
  val ninety = new N(90) with Tenth

  val thousand = new Thou[Million] with Auxiliary[Thousand]
  val million = new Mill[Million]

  //yeah, we are rich too
  @inline implicit def nWrapper(n: N): RichN = new RichN(n)

  val MaxValue = cons(Long.MaxValue)
  val MinValue = cons(Long.MinValue)

  private [lleggieri] def cons(n: Long): N with Final = new N(n) with Final
}
