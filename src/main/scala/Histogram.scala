import smile.data.{Attribute, AttributeDataset, NominalAttribute, NumericAttribute}
import smile.plot.hist
import smile.read

object Histogram extends App {
  val attributes = new Array[Attribute](3)

  attributes(0) = new NumericAttribute("RM")
  attributes(1) = new NumericAttribute("LSTAT")
  attributes(2) = new NumericAttribute("PTRATIO")

  val label = new NominalAttribute("MEDV")

  val dataFileUri = this.getClass.getClassLoader.getResource("boston.csv").toURI.getPath
  val data: AttributeDataset = read.csv(dataFileUri, attributes = attributes, response = Some((label, 3)), header = true)

  val window = hist(data.x().map(_(0)), 50)
  window.canvas.setAxisLabels("MEDV", "Probability")

}
