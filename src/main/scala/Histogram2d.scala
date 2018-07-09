import smile.plot.hist
import smile.stat.distribution.MultivariateGaussianDistribution

object Histogram2d extends App {
  val gauss = new MultivariateGaussianDistribution(
    // Mean vector
    Array(0.0, 0.0),
    // Covariance matrix.
    Array(Array(1.0, 0.6), Array(0.6, 2.0)))

  // Generate 10k data points.
  val data = (0 until 10000) map { _ => gauss.rand() }

  hist(data.toArray, 50)
}
