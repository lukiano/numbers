package com.lleggieri

/**
 * These Numbers have methods to build Numbers from 21 to 99. Ex: forty two.
 */
private[lleggieri] trait Tenth extends Hundred with Thousand with Million { n: N =>

  def one: N = n + N.one
  def two: N = n + N.two
  def three: N = n + N.three
  def four: N = n + N.four
  def five: N = n + N.five
  def six: N = n + N.six
  def seven: N = n + N.seven
  def eight: N = n + N.eight
  def nine: N = n + N.nine

  private[lleggieri] val value = n.v

}

