package com.lleggieri

import scalaz.Monoid

object Scalaz {

  class N_Monoid extends Monoid[N] {
    def append(f1: N, f2: => N) = f1 + f2

    def zero: N = N.zero

  }

  implicit val monoid = new N_Monoid

}
