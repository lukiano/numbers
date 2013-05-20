import org.scalatest.FunSuite
import com.lucho.N._

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

  test("implicit") {
    assert(one.toLong == 1)
  }

  test("sort") {
    assert(one < two)
    assert(four > three)
    val unsorted = List(three, one, two)
    val expected = List(one, two, three)
    //assert(unsorted.sorted === expected)
  }

}
