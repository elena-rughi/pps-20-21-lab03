package exercises

import u03.Streams._
import u03.Streams.Stream._

object Streams {

    /*
      5. Define a function, dual to take(s)(n), called drop(s)(n),
      which drops the first n elements of the stream s.
     */
    def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream,n) match {
      case (Cons(_, tail), n) if n>0 => drop(tail())(n - 1)
      case _ => stream
    }

    /*
      6. Implement a generic function constant(k) which generates an infinite
      stream of value k.
     */
    def constant[A](v: => A): Stream[A] = cons(v, constant(v))

    /*
      7. Implement an infinite stream for the Fibonacci series
     */
    def fibonacci(): Stream[Int] =  fib(0, 1)
    private def fib(a: => Int, b: => Int): Stream[Int] = cons(a, fib(b, a+b))


}
