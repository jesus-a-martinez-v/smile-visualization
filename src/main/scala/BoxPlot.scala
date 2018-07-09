import smile.data.{Attribute, AttributeDataset, NominalAttribute, NumericAttribute}
import smile.plot.boxplot
import smile.read

object BoxPlot extends App {
  val attributes = new Array[Attribute](4)

  attributes(0) = new NumericAttribute("sepal length in cm")
  attributes(1) = new NumericAttribute("sepal width in cm")
  attributes(2) = new NumericAttribute("petal length in cm")
  attributes(3) = new NumericAttribute("petal width in cm")

  val label = new NominalAttribute("class")

  val dataFileUri = this.getClass.getClassLoader.getResource("iris.data").toURI.getPath
  val data: AttributeDataset = read.csv(dataFileUri, attributes = attributes, response = Some((label, 4)))

  val groups = (data.x().map(_(0)) zip data.labels().map("class %d" format _)).groupBy(_._2)
  val labels = groups.keys.toArray

  val actualData = groups.values.map { a => a.map(_._1) } toArray
  val window = boxplot(actualData, labels)
  window.canvas.setAxisLabels("", attributes(0).getName)

}
