This project contains a very simple demo of the usefulness of the Futures
in java.

Just clone this repository, and run ''mvn clean test''.

If you have just a typical Maven installation configured, this should show two tests executing:
* the first one, not using futures, will take about 30 seconds to complete the computation
* the second one, using futures, will take about 15 seconds (the longest computation of the three)
  to complete since it'll run the "computations" in parallel.

There's two branches in this git repo:
* _master_ contains java6 code. It uses anonymous callable instances
* _lambdas_ contains java8 code. It uses lambdas instead of anonymous classes. You should see the code is far more concise and clear (provided you know the (a,b) -> a+b typical lambda syntax, granted).

Hope this helps.

Don't hesitate to give feedback.
