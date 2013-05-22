package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait Hundred { n: N =>

  def hundred(t: Tenth): N with Tenth = if (v < 100) new N(v * 100 + t.value) with Tenth else new N((v / 100) * 100 + (v % 100) * 100 + t.value) with Tenth
  def hundred(e: HTM): N with HTM = if (v < 100) new N(v * 100 + e.value) with HTM else new N((v / 100) * 100 + (v % 100) * 100 + e.value) with HTM

  def hundred(aux: Auxiliary): N with HTM = new N((this.hundred).v * aux.multiplier) with HTM

  def hundred: N with HTM = if (v < 100) new N(v * 100) with HTM else new N((v / 100) * 100 + (v % 100) * 100) with HTM

}
