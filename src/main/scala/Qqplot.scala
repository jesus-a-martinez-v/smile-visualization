import smile.plot.qqplot
import smile.stat.distribution.GaussianDistribution

object Qqplot extends App {
  val gauss = GaussianDistribution.getInstance

  val data = (0 until 1000) map (_ => gauss.rand)

  qqplot(data.toArray)

}
