package com.lleggieri

/**
 * M from Million. Adds these extensions to a Number.
 */
private[lleggieri] trait Million { n: N =>

  def million(t: Tenth): N with Tenth with HundredBeforeThousand with Thousand = new N(v * 1000000 + t.value) with Tenth with HundredBeforeThousand with Thousand
  def million(e: Extensible): N with HundredBeforeThousand with Thousand = new N(v * 1000000 + e.value) with HundredBeforeThousand with Thousand

  def million: N with HundredBeforeThousand with Thousand = new N(v * 1000000) with HundredBeforeThousand with Thousand

}
