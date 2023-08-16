package linear;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import linear.algebra.GaussianElimination;// ??

@Suite
@SelectClasses({
  GaussianEliminationStructureTest.class
  ,GaussianEliminationTest.class
})
public class GaussianEliminationTestSuite {}
