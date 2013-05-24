package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait Hundred[A] { n: N =>

  private def calc(add: Long) = compute(v, 100, add)

  def hundred(t: Tenth)(implicit ev: Hundred.HundredLike[A]) = ev.newNWithTenth(calc(t.value))
  def hundred(e: Extensible)(implicit ev: Hundred.HundredLike[A]) = ev.newN(calc(e.value))

  def hundred = new N(calc(0)) with Final

  private def calcWithMultiplier(multiplier: Long) = compute(v, 100 * multiplier, 0)

  def hundred(aux: Auxiliary[A])(implicit ev: Hundred.HundredLike[A]) = ev.newN(calcWithMultiplier(aux.multiplier))
  def hundred(aux: Thou[A])(implicit ev: Hundred.HundredLike[A]) = ev.newN(calcWithMultiplier(aux.multiplier))
  def hundred(aux: Mill[A])(implicit ev: Hundred.HundredLike[A]) = ev.newN(calcWithMultiplier(aux.multiplier))

}

private[lleggieri] object Hundred {

  private[lleggieri] trait HundredLike[A] {
    def newN(value: Long): N with A
    def newNWithTenth(value: Long): N with A with Tenth
  }

  implicit object ThousandHundredLike extends HundredLike[Thousand] {
    def newN(value: Long) = new N(value) with Thousand
    def newNWithTenth(value: Long) = new N(value) with Thousand with Tenth
  }

  implicit object MillionHundredLike extends HundredLike[Million] {
    def newN(value: Long) = new N(value) with Million
    def newNWithTenth(value: Long) = new N(value) with Million with Tenth
  }

  implicit object FinalHundredLike extends HundredLike[Final] {
    def newN(value: Long) = new N(value) with Final
    def newNWithTenth(value: Long) = new N(value) with Final with Tenth
  }

}
