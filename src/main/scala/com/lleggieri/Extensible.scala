package com.lleggieri

/**
 * These Numbers can be used with thousand, hundred or million.
 */
private[lleggieri] trait Extensible extends Hundred[Million] with Thousand with Million { n: N =>

  private[lleggieri] val value = n.v

}
