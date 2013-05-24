package com.lleggieri

/**
 * These Numbers have methods to build Numbers from 21 to 99. Ex: forty two.
 */
private[lleggieri] trait Tenth { n: N =>

  def one = n + N.one
  def two = n + N.two
  def three = n + N.three
  def four = n + N.four
  def five = n + N.five
  def six = n + N.six
  def seven = n + N.seven
  def eight = n + N.eight
  def nine = n + N.nine

  private[lleggieri] val value = n.v

}

