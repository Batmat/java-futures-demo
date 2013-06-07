This project contains a very simple demo of the usefulness of the Futures
in java.

Just clone this repository, and run ''mvn clean test''.

If you have just a typical Maven installation configured, this should show two tests executing:
* the first one, not using futures, will take about 30 seconds to complete the computation
* the second one, using futures, will take about 15 seconds (the longest computation of the three)
  to complete since it'll run the "computations" in parallel.

Hope this helps.

Don't hesitate to give feedback.
