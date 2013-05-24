package com.lleggieri

/**
 * Adds these extensions to a Number.
 */
private[lleggieri] trait Thousand { n: N =>

  private def calc(add: Long) = compute(v, 1000, add)

  def thousand(t: Tenth) = new N(calc(t.value)) with Tenth with Hundred[Final]
  def thousand(e: Extensible) = new N(calc(e.value)) with Hundred[Final]

  def thousand = new N(calc(0)) with Hundred[Final]

}

