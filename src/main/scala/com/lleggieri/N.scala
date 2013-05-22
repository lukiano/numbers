package com.lleggieri

import language.implicitConversions
import language.postfixOps

/**
 * Class N from Number.
 * @param v the long number it represents.
 */
abstract class N(val v: Long) extends OrderedN {

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
  implicit val orderingE = new Ordering[N with HTM] { def compare(x: N with HTM, y: N with HTM) = x.compare(y) }
  implicit val orderingT = new Ordering[N with Tenth] { def compare(x: N with Tenth, y: N with Tenth) = x.compare(y) }
  implicit val orderingF = new Ordering[N with Final] { def compare(x: N with Final, y: N with Final) = x.compare(y) }

  /*
  @inline implicit def toLong(e: E): Long = e.asInstanceOf[N].v
  @inline implicit def toLong(t: T): Long = t.asInstanceOf[N].v
  @inline implicit def toLong(f: F): Long = f.asInstanceOf[N].v
  */

  val zero = new N(0) with Final

  val one = new N(1) with HTM
  val two = new N(2) with HTM
  val three = new N(3) with HTM
  val four = new N(4) with HTM
  val five = new N(5) with HTM
  val six = new N(6) with HTM
  val seven = new N(7) with HTM
  val eight = new N(8) with HTM
  val nine = new N(9) with HTM

  val ten = new N(10) with HTM
  val eleven = new N(11) with HTM
  val twelve = new N(12) with HTM
  val thirteen = new N(13) with HTM
  val fourteen = new N(14) with HTM
  val fifteen = new N(15) with HTM
  val sixteen = new N(16) with HTM
  val seventeen = new N(17) with HTM
  val eighteen = new N(18) with HTM
  val nineteen = new N(19) with HTM

  val twenty = new N(20) with Tenth
  val thirty = new N(30) with Tenth
  val forty = new N(40) with Tenth
  val fifty = new N(50) with Tenth
  val sixty = new N(60) with Tenth
  val seventy = new N(70) with Tenth
  val eighty = new N(80) with Tenth
  val ninety = new N(90) with Tenth

  val thousand = new Thou
  val million = new Mill

  //yeah, we are rich too
  @inline implicit def nWrapper(n: N): RichN = new RichN(n)
}
