// $Header: //info.ravenbrook.com/project/jili/version/1.1/test/mnj/lua/SpeedMIDlet.java#1 $
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

/**
 * SpeedMIDlet.java
 * Runs a bunch of lua scripts designed to measure speed.
 */

package mnj.lua;

import java.io.Reader;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;

public class SpeedMIDlet extends MIDlet 
{
    public SpeedMIDlet()
    {
        String report = Speed.report();
        
        Form form1 = new Form("Speed Test");
        form1.append( new StringItem(report, null ) );
        Display.getDisplay(this).setCurrent(form1);
    }

    public void startApp()
    {
        
    }

    public void pauseApp()
    {
    }
    
    public void destroyApp(boolean unconditional)
    {
    }
}
