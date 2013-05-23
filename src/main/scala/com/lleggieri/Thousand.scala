package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait Thousand { n: N =>

  def thousand(t: Tenth): N with Tenth with Hundred = if (v < 1000) new N(v * 1000 + t.value) with Tenth with Hundred else new N((v / 1000) * 1000 + (v % 1000) * 1000 + t.value) with Tenth with Hundred
  def thousand(e: Extensible): N with Hundred = if (v < 1000) new N(v * 1000 + e.value) with Hundred else new N((v / 1000) * 1000 + (v % 1000) * 1000 + e.value) with Hundred

  def thousand: N with Hundred = if (v < 1000) new N(v * 1000) with Hundred else new N((v / 1000) * 1000 + (v % 1000) * 1000) with Hundred

}

