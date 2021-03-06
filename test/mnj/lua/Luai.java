// $Header: //info.ravenbrook.com/project/jili/version/1.1/test/mnj/lua/Luai.java#1 $
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

// Lua script interpreter for JSE environments.
// Analogous to the lua interpreter provided by PUC-Rio

package mnj.lua;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public final class Luai
{
  public static void main(String[] arg)
  {
    try
    {
      String name = arg[0];
      InputStream in = new BufferedInputStream(new FileInputStream(name));

      Lua L = new Lua();
      BaseLib.open(L);
      PackageLib.open(L);
      MathLib.open(L);
      OSLib.open(L);
      StringLib.open(L);
      TableLib.open(L);

      int status = L.load(in, "@" + name);
      in.close();
      if (status != 0)
      {
        throw new Exception("Error compiling " + name + ": " +
            L.value(1));
      }
      status = L.pcall(0, Lua.MULTRET, new AddWhere());
      if (status != 0)
      {
        System.out.println(L.value(-1));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
