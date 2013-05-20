import org.scalatest.FunSuite
import com.lucho.N._

class TestN extends FunSuite {

  test("sum") {
    assert(one + 1 == 2)
    assert(1 + one == 2)
  }

  test("equality") {
    assert(one == 1)
    //assert((1 == one)) //cannot override ==
    assert((twenty three) === 23)
    assert((one hundred) === 100)
    assert((one hundred three) === 103)
    assert((one hundred twenty) === 120)
    assert((one hundred twenty three) === 123)

    assert((two thousand) === 2000)
    assert((two thousand five) === 2005)
    assert((two thousand twenty) === 2020)
    assert((two thousand twenty three) === 2023)
    assert((two thousand one hundred) === 2100)
    assert((two thousand one hundred five) === 2105)
    assert((two thousand one hundred twenty) === 2120)
    assert((two thousand one hundred twenty three) === 2123)
    assert((three million (one hundred twenty three)) === 3000123)
    assert((three million four hundred eleven thousand one hundred twenty three) === 3411123)
    assert(zero === 0)
  }

  test("equality 2") {
    assert(six == six)
    assert(six === six)
  }

  test("minus") {
    assert((two - two) == 0)
    assert((two - two) === 0)

    assert(zero == (two - two))
    assert(zero === (two - two))
  }

  test("outliers") {
    //val x1 = (one hundred hundred) cannot do it, ok
    //val x2 = (one thousand hundred) cannot do it, ok
    assert((one hundred thousand) === 100000)
  }

}
