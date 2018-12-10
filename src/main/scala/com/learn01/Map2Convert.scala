package com.learn01

import scala.collection.mutable._
import scala.util.control.Breaks._
/*
 *本案例：找出某个字符第三次出现，并输出
 * 在scala中同一行写两个语句必须加分号
 */
object Map2Convert {
  def main(args: Array[String]): Unit = {
    val str = "qwerqhjkqwklw"
    var m = Map[Char, Int]()
    breakable {
      for (i <- str) {
        m.get(i) match {
          case Some(j) => {
            if (j == 2) {
              print(i); break
            } else {
              //将(i->j)转变为(i->(j+1))
              m(i) = j + 1
            }
          }
          case None => m ++= Map(i -> 1)
        }
      }
    }
    //    println(m)
  }
}
