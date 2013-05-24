package com.lleggieri

/**
 * M from Million. Adds these extensions to a Number.
 */
private[lleggieri] trait Million { n: N =>

  private def calc(add: Long) = compute(v, 1000000, add)

  def million(t: Tenth) = new N(calc(t.value)) with Tenth with Hundred[Thousand] with Thousand
  def million(e: Extensible) = new N(calc(e.value)) with Hundred[Thousand] with Thousand

  def million = new N(calc(0)) with Hundred[Thousand] with Thousand

}
