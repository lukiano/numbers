package com.lleggieri

import spire.algebra.{AdditiveMonoid, Monoid}

object Spire {

  implicit val additiveMonoid = new AdditiveMonoid[N] {
    def plus(x: N, y: N) = x + y

    def zero = N.zero
  }

  implicit val monoid = additiveMonoid.additive
}
