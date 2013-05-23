package test

import language.postfixOps

import org.scalatest.FunSuite
import com.lleggieri.N._

class TestN extends FunSuite {

  test("sum") {
    assert(one.v + 1 === 2)
    assert(1 + one.v === 2)
    assert(one + one === two)
  }

  test("equality") {
    assert(one.v == 1)
    assert(one.v === 1)
    //assert((1 == one)) //cannot override ==
    assert((twenty three).v === 23)
    assert((one hundred).v === 100)
    assert((one hundred three).v === 103)
    assert((one hundred twenty).v === 120)
    assert((one hundred twenty three).v === 123)

    assert((two thousand).v === 2000)
    assert((two thousand five).v === 2005)
    assert((two thousand twenty).v === 2020)
    assert((two thousand twenty three).v === 2023)
    assert((two thousand one hundred).v === 2100)
    assert((two thousand one hundred five).v === 2105)
    assert((two thousand one hundred twenty).v === 2120)
    assert((two thousand one hundred twenty three).v === 2123)
    assert((three million one hundred twenty three).v === 3000123)
    assert((three million four hundred eleven thousand one hundred twenty three).v === 3411123)
    assert(zero.v === 0)
  }

  test("equality 2") {
    assert(six == six)
    assert(six === six)
  }

  test("minus") {
    assert((two - two).v == 0)
    assert((two - two).v === 0)
    assert((two - two) === zero)

    assert(zero == (two - two))
    assert(zero === (two - two))
  }

  test("outliers") {
    //val x1 = (one hundred hundred) cannot do it, ok
    //val x2 = (one thousand hundred) cannot do it, ok
    assert((one hundred thousand).v === 100000)
    assert((one hundred million).v === 100000000)
    //assert((one hundred zero).v === 100000000) cannot do it, ok
    //assert(((two + four) hundred) === (six hundred)) cannot do it, ok
  }

  test("sort") {
    assert(one < two)
    assert(four > three)
    val unsortedN = List(forty two, three, one, one hundred, two, twenty)
    val expectedN = List(one, two, three, twenty, forty two, one hundred)
    assert(unsortedN.sorted === expectedN)

    val unsortedE = List(three, one, one hundred, two)
    val expectedE = List(one, two, three, one hundred)
    assert(unsortedE.sorted === expectedE)

    val unsortedT = List(forty, twenty, eighty)
    val expectedT = List(twenty, forty, eighty)
    assert(unsortedT.sorted === expectedT)

    val unsortedF = List(one + four, two + one, two + zero)
    val expectedF = List(one + one, one + two, two + three)
    assert(unsortedF.sorted === expectedF)

  }

  test("wealth") {
    val list = 1l to 10
    assert(list.length === 10)

    val list2 = one to ten
    assert(list2.length === 10)

    val list3 = one until twenty
    assert(list3.length === 19)

    //we need parenthesis here
    val list4 = one to (forty two)
    assert(list4.length === 42)

    val list5 = (twenty three) to ninety
    assert(!list5.contains(42)) //no numeric numbers here
    assert(list5.contains(forty two))
    //two million three million
    //two thousand three thousand
    //one hundred one hundred
    val set1 = Set(one, two, three)
    assert(set1.contains(three))
  }

}
