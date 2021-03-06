// $Header: //info.ravenbrook.com/project/jili/version/1.1/test/mnj/lua/TableLibTest.java#1 $
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
// TableLibTest.lua - test functions.
// TableLibTest.luc - compiled .lua file.

/**
 * J2MEUnit tests for Jill's TableLib (table library).  DO NOT SUBCLASS.
 * public access granted only because j2meunit makes it necessary.
 */
public class TableLibTest extends JiliTestCase
  {
  /** void constructor, necessary for running using
   * <code>java j2meunit.textui.TestRunner TableLibTest</code>
   */
  public TableLibTest() { }

  /** Clones constructor from superclass.  */
  private TableLibTest(String name)
  {
    super(name);
  }

  /**
   * Tests TableLib.
   */
  public void testTableLib()
  {
    System.out.println("TableLibTest.testTableLib()");
    Lua L = new Lua();

    TableLib.open(L);

    Object lib = L.getGlobal("table");
    assertTrue("table table defined", L.isTable(lib));

    // Test that each table library name is defined as expected.
    String[] name =
    {
      "concat",
      "insert",
      "maxn",
      "remove",
      "sort"
    };
    for (int i=0; i<name.length; ++i)
    {
      Object o = L.getField(lib, name[i]);
      assertTrue(name[i] + " exists", !L.isNil(o));
    }
  }

  /**
   * Opens the base and table libraries into a fresh Lua state,
   * calls a global function, and returns the Lua state.
   * @param name  name of function to call.
   * @param n     number of results expected from function.
   */
  private Lua luaGlobal(String name, int n)
  {
    Lua L = new Lua();
    BaseLib.open(L);
    TableLib.open(L);
    loadFileAndRun(L, "TableLibTest", name, n);
    return L;
  }

  /**
   * Calls a global lua function and checks that <var>n</var> results
   * are all true.
   */
  private void nTrue(String name, int n)
  {
    Lua L = luaGlobal(name, n);
    for (int i=1; i<=n; ++i)
    {
      assertTrue("Result " + i + " is true",
          L.valueOfBoolean(true).equals(L.value(i)));
    }
  }

  /**
   * Used for many test case instances, others override this in an
   * anonymous class.
   */
  public void runTest()
  {
    nTrue(getName(), 1);
  }

  public Test suite()
  {
    TestSuite suite = new TestSuite();

    suite.addTest(new TableLibTest("testTableLib")
      {
        public void runTest() { testTableLib(); }
      });
    suite.addTest(new TableLibTest("testconcat"));
    suite.addTest(new TableLibTest("testconcat2"));
    suite.addTest(new TableLibTest("testinsertremove"));
    suite.addTest(new TableLibTest("testmaxn"));
    suite.addTest(new TableLibTest("testsort"));

    return suite;
  }
}
