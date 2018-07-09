import smile.interpolation.BicubicInterpolation
import smile.plot.{Palette, heatmap}

object Heatmap extends App {
  // This is the matrix to be displayed
  val z = Array(
    Array(1.0, 2.0, 4.0, 1.0),
    Array(6.0, 3.0, 5.0, 2.0),
    Array(4.0, 2.0, 1.0, 5.0),
    Array(5.0, 4.0, 2.0, 3.0)
  )

  // Let's augment this matrix with cubic interpolation
  val x = Array(0.0, 1.0, 2.0, 3.0)
  val y = Array(0.0, 1.0, 2.0, 3.0)

  val bicubic = new BicubicInterpolation(x, y, z)
  val Z =  Array.ofDim[Double](101, 101)

  for {
    i <- 0 to 100
    j <- 0 to 100
  } Z(i)(j) = bicubic.interpolate(i * 0.03, j * 0.03)

  heatmap(Z, Palette.jet(256))
}

