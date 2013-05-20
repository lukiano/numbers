package com.lucho

private[lucho] class N(value: Long) {

  private def self = value

  override def equals(that: Any) = that match {
    case z: Z => value == 0
    case n: N => value == n.self
    case l: Long => value == l
    case i: Int => value == i
    case _ => false
  }

  override def hashCode() = value.toInt

  def hundred(n: N): N = if (value < 100) new N(value * 100 + n.self) else new N((value / 100) * 100 + (value % 100) * 100 + n.self)
  def hundred(t: T): T = if (value < 100) new T(value * 100 + t.self) else new T((value / 100) * 100 + (value % 100) * 100 + t.self)

  def hundred(thou: Thou): N = new N((this hundred) * 1000)

  def hundred: N = if (value < 100) new N(value * 100) else new N((value / 100) * 100 + (value % 100) * 100)

  def thousand(n: N): N = if (value < 1000) new N(value * 1000 + n.self) else new N((value / 1000) * 1000 + (value % 1000) * 1000 + n.self)
  def thousand(t: T): T = if (value < 1000) new T(value * 1000 + t.self) else new T((value / 1000) * 1000 + (value % 1000) * 1000 + t.self)

  def thousand: N = if (value < 1000) new N(value * 1000) else new N((value / 1000) * 1000 + (value % 1000) * 1000)

  def million(n: N): N = new N(value * 1000000 + n)
  def million(t: T): N = new N(value * 1000000 + t)

  override def toString = value.toString
}

private[lucho] class T(value: Long) extends N(value) {

  def one = new N(value + 1)
  def two = new N(value + 2)
  def three = new N(value + 3)
  def four = new N(value + 4)
  def five = new N(value + 5)
  def six = new N(value + 6)
  def seven = new N(value + 7)
  def eight = new N(value + 8)
  def nine = new N(value + 9)

}

private[lucho] class Z {

  override def toString = "0"

  override def equals(that: Any) = that match {
    case z: Z => true
    case n: N => n == 0
    case l: Long => l == 0
    case i: Int => i == 0
    case _ => false
  }

  override def hashCode() = 0

}

private[lucho] class Thou {}

object N {

  @inline implicit def toLong(n: N): Long = n.self
  @inline implicit def toLong(Z: Z): Long = 0

  @inline implicit def toN(l: Long) = new N(l)

  val zero = new Z

  val one = new N(1)
  val two = new N(2)
  val three = new N(3)
  val four = new N(4)
  val five = new N(5)
  val six = new N(6)
  val seven = new N(7)
  val eight = new N(8)
  val nine = new N(9)

  val ten = new N(10)
  val eleven = new N(11)
  val twelve = new N(12)
  val thirteen = new N(13)
  val fourteen = new N(14)
  val fifteen = new N(15)
  val sixteen = new N(16)
  val seventeen = new N(17)
  val eighteen = new N(18)
  val nineteen = new N(19)

  val twenty = new T(20)
  val thirty = new T(30)
  val forty = new T(40)
  val fifty = new T(50)
  val sixty = new T(60)
  val seventy = new T(70)
  val eighty = new T(80)
  val ninety = new T(90)

  val thousand = new Thou

}
