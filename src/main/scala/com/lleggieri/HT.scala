package com.lleggieri

/**
 * These Numbers can be used with thousand, or hundred.
 */
private[lleggieri] trait HT extends Hundred with Thousand { n: N =>

  private[lleggieri] val value = n.v

}
