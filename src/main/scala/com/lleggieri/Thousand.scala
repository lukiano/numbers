package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait Thousand { n: N =>

  def thousand(t: Tenth): N with Tenth = if (v < 1000) new N(v * 1000 + toValue(t)) with Tenth else new N((v / 1000) * 1000 + (v % 1000) * 1000 + toValue(t)) with Tenth
  def thousand(e: HTM): N with HTM = if (v < 1000) new N(v * 1000 + toValue(e)) with HTM else new N((v / 1000) * 1000 + (v % 1000) * 1000 + toValue(e)) with HTM

  def thousand: N with HTM = if (v < 1000) new N(v * 1000) with HTM else new N((v / 1000) * 1000 + (v % 1000) * 1000) with HTM

  private def toValue(t: Tenth): Long = t.value
  private def toValue(e: HTM): Long = e.value

}

