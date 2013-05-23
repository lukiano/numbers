package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait HundredBeforeMillion { n: N =>

  def hundred(t: Tenth): N with Tenth with Million with Thousand = if (v < 100) new N(v * 100 + t.value) with Tenth with Million with Thousand else new N((v / 100) * 100 + (v % 100) * 100 + t.value) with Tenth with Million with Thousand
  def hundred(e: Extensible): N with Million with Thousand = if (v < 100) new N(v * 100 + e.value) with Million with Thousand else new N((v / 100) * 100 + (v % 100) * 100 + e.value) with Million with Thousand

  def hundred(aux: Auxiliary): N with Million with Thousand = new N((this.hundred).v * aux.multiplier) with Million with Thousand

  def hundred: N with Final = if (v < 100) new N(v * 100) with Final else new N((v / 100) * 100 + (v % 100) * 100) with Final

}
