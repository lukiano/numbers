package com.lleggieri

/**
 * These auxiliary classes help building numbers like "one hundred thousand" or "two hundred million"
 */
private[lleggieri] trait Auxiliary[A] {
  private[lleggieri] val multiplier: Long
}

private[lleggieri] class Thou[A] {
  private[lleggieri] val multiplier = 1000L
}

private[lleggieri] class Mill[A] {
  private[lleggieri] val multiplier = 1000000L
}

