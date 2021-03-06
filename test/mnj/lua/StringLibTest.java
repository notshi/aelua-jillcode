// $Header: //info.ravenbrook.com/project/jili/version/1.1/test/mnj/lua/StringLibTest.java#1 $
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
// StringLibTest.lua - test functions.
// StringLibTest.luc - compiled .lua file.

/**
 * J2MEUnit tests for Jill's StringLib (string library).  DO NOT SUBCLASS.
 * public access granted only because j2meunit makes it necessary.
 */
public class StringLibTest extends JiliTestCase
  {
  /** void constructor, necessary for running using
   * <code>java j2meunit.textui.TestRunner StringLibTest</code>
   */
  public StringLibTest() { }

  /** Clones constructor from superclass.  */
  private StringLibTest(String name)
  {
    super(name);
  }

  /**
   * Tests StringLib.
   */
  public void testStringLib()
  {
    System.out.println("StringLibTest.testStringLib()");
    Lua L = new Lua();

    StringLib.open(L);

    Object lib = L.getGlobal("string");
    assertTrue("string table defined", L.isTable(lib));

    // Test that each string library name is defined as expected.
    String[] name =
    {
      "byte",
      "char",
      "dump",
      "find",
      "format",
      "gmatch",
      "gsub",
      "len",
      "lower",
      "match",
      "rep",
      "reverse",
      "sub",
      "upper"
    };
    for (int i=0; i<name.length; ++i)
    {
      Object o = L.getField(lib, name[i]);
      assertTrue(name[i] + " exists", !L.isNil(o));
    }
  }

  /**
   * Opens the base and string libraries into a fresh Lua state,
   * calls a global function, and returns the Lua state.
   * @param name  name of function to call.
   * @param n     number of results expected from function.
   */
  private Lua luaGlobal(String name, int n)
  {
    Lua L = new Lua();
    BaseLib.open(L);
    StringLib.open(L);
    loadFileAndRun(L, "StringLibTest", name, n);
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
   * Used for many test case instances, others override this is an
   * anonymous class.
   */
  public void runTest()
  {
    nTrue(getName(), 1);
  }

  public void testlen()
  {
    nTrue("testlen", 2);
  }

  public void testlower()
  {
    nTrue("testlower", 3);
  }

  public void testrep()
  {
    nTrue("testrep", 3);
  }

  public void testupper()
  {
    nTrue("testupper", 3);
  }

  public void testsub()
  {
    nTrue("testsub", 3);
  }

  public void testmeta()
  {
    nTrue("testmeta", 2);
  }

  public void testreverse()
  {
    nTrue("testreverse", 2);
  }

  public void testbyte()
  {
    nTrue("testbyte", 5);
  }

  public void testchar()
  {
    nTrue("testchar", 2);
  }

  public void testfind()
  {
    nTrue("testfind", 6);
  }

  public void testmatch()
  {
    nTrue("testmatch", 2);
  }

  public Test suite()
  {
    TestSuite suite = new TestSuite();

    suite.addTest(new StringLibTest("testStringLib")
    {
        public void runTest() { testStringLib(); } });
    suite.addTest(new StringLibTest("testlen")
        {
        public void runTest() { testlen(); } });
    suite.addTest(new StringLibTest("testlower")
        {
        public void runTest() { testlower(); } });
    suite.addTest(new StringLibTest("testrep")
        {
        public void runTest() { testrep(); } });
    suite.addTest(new StringLibTest("testupper")
        {
        public void runTest() { testupper(); } });
    suite.addTest(new StringLibTest("testsub")
        {
        public void runTest() { testsub(); } });
    suite.addTest(new StringLibTest("testmeta")
        {
        public void runTest() { testmeta(); } });
    suite.addTest(new StringLibTest("testreverse")
        {
        public void runTest() { testreverse(); } });
    suite.addTest(new StringLibTest("testbyte")
        {
        public void runTest() { testbyte(); } });
    suite.addTest(new StringLibTest("testchar")
      {
        public void runTest() { testchar(); }
      });
    suite.addTest(new StringLibTest("testfind")
      {
        public void runTest() { testfind(); }
      });
    suite.addTest(new StringLibTest("testmatch")
      {
        public void runTest() { testmatch(); }
      });
    suite.addTest(new StringLibTest("testformat"));
    suite.addTest(new StringLibTest("testgsub"));
    suite.addTest(new StringLibTest("testgsub2"));
    suite.addTest(new StringLibTest("testgsub3"));
    suite.addTest(new StringLibTest("testgsub4"));
    suite.addTest(new StringLibTest("testgmatch"));
    suite.addTest(new StringLibTest("testformatmore"));
    suite.addTest(new StringLibTest("testformatx1"));
    suite.addTest(new StringLibTest("testformatx2"));
    suite.addTest(new StringLibTest("testformatx3"));
    suite.addTest(new StringLibTest("testformatx4"));
    suite.addTest(new StringLibTest("testformatx5"));
    suite.addTest(new StringLibTest("testformatx6"));
    suite.addTest(new StringLibTest("testformatx7"));
    suite.addTest(new StringLibTest("testdump"));
    suite.addTest(new StringLibTest("testaritherror"));
    return suite;
  }
}
