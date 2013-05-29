package com.lleggieri

import scalaz.Monoid

object Scalaz {

  implicit object additiveMonoid extends Monoid[N] {
    def append(f1: N, f2: => N) = f1 + f2

    def zero: N = N.zero

  }

}
