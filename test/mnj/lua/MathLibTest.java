// $Header: //info.ravenbrook.com/project/jili/version/1.1/test/mnj/lua/MathLibTest.java#1 $
// Copyright (c) 2006 Nokia Corporation and/or its subsidiary(-ies).
// All rights reserved.
// 
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject
// to the following conditions:
// 
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
// IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
// ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
// CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package mnj.lua;

// For j2meunit see http://j2meunit.sourceforge.net/
import j2meunit.framework.Test;
import j2meunit.framework.TestSuite;

// Auxiliary files
// MathLibTest.lua

/**
 * J2MEUnit tests for Jill's math library.  DO NOT SUBCLASS.
 * public access granted only because j2meunit makes it necessary.
 */
public class MathLibTest extends JiliTestCase
  {
  /** void constructor, necessary for running using
   * <code>java j2meunit.textui.TestRunner MathLibTest</code>
   */
  public MathLibTest() { }

  /** Clones constructor from superclass.  */
  private MathLibTest(String name)
  {
    super(name);
  }

  public void runTest()
  {
    // loads MathLibTest.lua and calls a function defined therein
    Lua L = new Lua();
    BaseLib.open(L);
    MathLib.open(L);

    loadFileAndRun(L, "MathLibTest.lua", getName(), 0);
    assertTrue(true);
  }

  public Test suite()
  {
    TestSuite suite = new TestSuite();

    suite.addTest(new MathLibTest("test1"));
    suite.addTest(new MathLibTest("test2"));
    suite.addTest(new MathLibTest("test3"));

    return suite;
  }
}
