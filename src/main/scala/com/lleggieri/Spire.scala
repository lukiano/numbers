package com.lleggieri

import spire.algebra.{AdditiveMonoid, Monoid}

object Spire {

  implicit val monoid = new AdditiveMonoid[N] {
    def plus(x: N, y: N) = x + y

    def zero = N.zero
  }

  implicit val additive = monoid.additive
}
