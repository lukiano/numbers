package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait Thousand { n: N =>

  def thousand(t: Tenth): N with Tenth with Hundred[Final] = new N(if (v < 1000) (v * 1000 + t.value) else ((v / 1000) * 1000 + (v % 1000) * 1000 + t.value)) with Tenth with Hundred[Final]
  def thousand(e: Extensible): N with Hundred[Final] = new N(if (v < 1000) (v * 1000 + e.value) else ((v / 1000) * 1000 + (v % 1000) * 1000 + e.value)) with Hundred[Final]

  def thousand: N with Hundred[Final] = new N(if (v < 1000) (v * 1000) else ((v / 1000) * 1000 + (v % 1000) * 1000)) with Hundred[Final]

}

