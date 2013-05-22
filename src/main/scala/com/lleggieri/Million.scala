package com.lleggieri

/**
 * M from Million. Adds these extensions to a Number.
 */
private[lleggieri] trait Million { n: N =>

  def million(t: Tenth): N with Tenth = new N(v * 1000000 + toValue(t)) with Tenth
  def million(e: HTM): N with HTM = new N(v * 1000000 + toValue(e)) with HTM

  def million: N with HTM = new N(v * 1000000) with HTM

  private def toValue(t: Tenth): Long = t.value
  private def toValue(e: HTM): Long = e.value

}
