package exercises

import u02.Modules.Person
import u02.Modules.Person.Teacher
import u03.Lists.List._
import u03.Lists._
import u02.Optionals.Option._
import u02.Optionals._

object Lists {
  /*
    1.  Consider the List type introduced in class. Analogously to sum and
      append, create the following functions:
      a) def drop[A](l: List[A], n: Int): List[A]
      b) def flatMap[A,B](l: List[A])(f: A => List[B]): List[B]
      c) Write map in terms of flatMap
      d) Write filter in terms of flatMap
  */

  // select all the elements except the first n elements of the list.
  def drop[A](l: List[A], n: Int): List[A] = (l, n) match {
    case (Cons(h, t), n) if n > 0 && h != Nil() => drop(t, n-1)
    case _ => l
  }

  def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = l match {
    case Cons(h, t) => append(f(h), flatMap(t)(f))
    case Nil() => Nil()
  }

  def myMap[A,B](l: List[A])(mapper: A => B): List[B] = flatMap(l)(v => Cons(mapper(v), Nil()))

  def myFilter[A](l: List[A])(pred: A => Boolean): List[A] = flatMap(l)(v => {
    if (pred(v)) Cons(v, Nil())
    else Nil()
  })

  /*
    2.  Considering both List and Option, create the following:
        def max(l: List[Int]): Option[Int]
   */
  def max(l: List[Int]): Option[Int] = l match {
    case Cons(h, t) => {
      val ll : List[Int] = filter(l)( _ > h)
      if (ll == Nil()) Some(h)
      else max(ll)
    }
    case Nil() => None()
  }

  /*
    3.  Consider Person and List. Create a function that takes a list of Persons
        and returns a list containing only the courses of Teachers in that list
   */
  def getCourses(people: List[Person]): List[String] =
    map(filter(people)(_.isInstanceOf[Teacher]))(t => t.asInstanceOf[Teacher].course)

  

}
