import java.awt.Color
import java.lang.Math.{PI, cos, pow, sin}

import smile.plot.line

object LineChart extends App {
  // Let's draw a heart ;)
  val heart = -PI to PI by 0.1 map { t =>
    val x = 16 * pow(sin(t), 3)
    val y = 13 * cos(t) - 5 * cos(2 * t) - 2 * cos(3 * t) - cos(4 * t)
    Array(x, y)
  }

  line(heart.toArray, color = Color.RED)
}
