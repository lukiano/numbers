package com

package object lleggieri {

    def compute(v: Long, guard: Long, add: Long): Long = add + guard * (if (v < guard) v else (v / guard) + (v % guard))

}
