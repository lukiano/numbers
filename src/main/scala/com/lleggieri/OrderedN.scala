package com.lleggieri

/**
 * Allows ordering and comparison between Numbers.
 */
trait OrderedN extends Ordered[N] { n: N =>

  override def compare(that: N): Int = Ordering.Long.compare(v, that.v)

  def + (that: N) = N.cons(v + that.v)
  def - (that: N) = N.cons(v - that.v)
  def * (that: N) = N.cons(v * that.v)
  def / (that: N) = N.cons(v / that.v)
  def % (that: N) = N.cons(v % that.v)

}
