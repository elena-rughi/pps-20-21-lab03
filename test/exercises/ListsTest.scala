package exercises

import exercises.Lists._
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.Modules.Person
import u02.Modules.Person.{Student, Teacher}
import u03.Lists.List._
import u03.Lists._
import u02.Optionals.Option.Some

class ListsTest {

  @Test def testDrop() ={
    val lst = Cons(10 , Cons(20 , Cons(30 , Nil()))) // 10 20 30
    assertEquals(Cons(20 , Cons(30 , Nil())).toString(), drop( lst ,1).toString()) // Cons (20 , Cons (30 , Nil () ) )
    assertEquals(Cons(30 , Nil()).toString(), drop(lst ,2).toString())
    assertEquals(Nil().toString(), drop(lst ,5).toString())
  }

  @Test def testFlatMap() = {
    val lst = Cons(10, Cons(20, Cons(30, Nil()))) // 10 20 30

    assertEquals( Cons(11 , Cons(21 , Cons(31 , Nil()))).toString(),
                  flatMap(lst)(v => Cons(v+1, Nil())).toString())

    assertEquals( Cons(11 , Cons(12 , Cons(21 , Cons(22 , Cons(31 , Cons(32 , Nil())))))).toString(),
                  flatMap(lst)(v => Cons(v+1 , Cons(v+2 , Nil()))).toString())

  }

  @Test def testMap() = {
    val lst = Cons(10, Cons(20, Cons(30, Nil()))) // 10 20 30
    assertEquals( map(lst)(v => v+1).toString(),
                  myMap(lst)(v => v+1).toString())
  }

  @Test def testFilter() = {
    val lst = Cons(10, Cons(20, Cons(30, Nil()))) // 10 20 30
    assertEquals( filter[Int](lst)(_ >=20).toString(),
                  myFilter[Int](lst)(_ >=20).toString())
  }

  @Test def testMax() = {
    assertEquals( Some(25).toString(),
                  max(Cons(10 , Cons(25 , Cons(20 , Nil())))).toString())

    assertEquals( Some(50).toString(),
      max(Cons(43 , Cons(50 , Cons(50 , Nil())))).toString())
  }

  @Test def testGetCourses() = {
    val people : List[Person] =
                  Cons(Teacher("Mario", "Italian"),
                  Cons(Student("Joe", 3),
                  Cons(Student("Marianna", 2),
                  Cons(Teacher("Steve", "History"),
                  Cons(Teacher("Anna", "Math"), Nil())))))
    val courses = Cons("Italian", Cons("History", Cons("Math", Nil())))

    assertEquals(courses.toString(), getCourses(people).toString())
  }

  @Test def testFold() = {
    val lst = Cons(3, Cons(7, Cons(1, Cons(5, Nil())))) //3 7 1 5
    //assertEquals(2, foldLeft[Int, Int](Nil())(2)(_-_))
    //assertEquals(-16, foldLeft(lst)(0)(_-_))
    assertEquals(-8, foldRight(lst)(0)(_-_))
    assertEquals(-6.8, toTwoDecimals(foldRight(lst)(1.2)(_-_)))
  }

  private def toTwoDecimals(in: Double): Double =
    BigDecimal(in).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble

}
