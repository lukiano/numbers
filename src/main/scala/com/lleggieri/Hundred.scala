package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait Hundred { n: N =>

  def hundred(t: Tenth): N with Tenth = if (v < 100) new N(v * 100 + t.value) with Tenth else new N((v / 100) * 100 + (v % 100) * 100 + t.value) with Tenth
  def hundred(e: Extensible): N with Final = if (v < 100) new N(v * 100 + e.value) with Final else new N((v / 100) * 100 + (v % 100) * 100 + e.value) with Final

  def hundred: N with Final = if (v < 100) new N(v * 100) with Final else new N((v / 100) * 100 + (v % 100) * 100) with Final

}
