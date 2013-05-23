package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait HundredBeforeThousand { n: N =>

  def hundred(t: Tenth): N with Tenth with Thousand = if (v < 100) new N(v * 100 + t.value) with Tenth with Thousand else new N((v / 100) * 100 + (v % 100) * 100 + t.value) with Tenth with Thousand
  def hundred(e: Extensible): N with Thousand = if (v < 100) new N(v * 100 + e.value) with Thousand else new N((v / 100) * 100 + (v % 100) * 100 + e.value) with Thousand

  def hundred(aux: Thou): N with Thousand = new N((this.hundred).v * aux.multiplier) with Thousand

  def hundred: N with Final = if (v < 100) new N(v * 100) with Final else new N((v / 100) * 100 + (v % 100) * 100) with Final

}
