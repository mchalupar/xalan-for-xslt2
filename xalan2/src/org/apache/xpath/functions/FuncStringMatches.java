/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the  "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * $Id: FuncStartsWith.java 468655 2006-10-28 07:12:06Z minchau $
 */
package org.apache.xpath.functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.xpath.XPathContext;
import org.apache.xpath.objects.XBoolean;
import org.apache.xpath.objects.XObject;

/**
 * 
 * @author wangqi.aguai.2011@gmail.com @ Beijing China
 *
 */
public class FuncStringMatches extends Function2Args
{
    static final long serialVersionUID = 2194585774699567928L;

  /**
   * Execute the function.  The function must return
   * a valid object.
   * @param xctxt The current execution context.
   * @return A valid XObject.
   *
   * @throws javax.xml.transform.TransformerException
   */
  public XObject execute(XPathContext xctxt) throws javax.xml.transform.TransformerException
  {
	 String input = m_arg0.execute(xctxt).str();
	 String pattern = m_arg1.execute(xctxt).str();
	 Pattern p = Pattern.compile(pattern);
	 Matcher m = p.matcher(input);
	 return m.find() ? XBoolean.S_TRUE : XBoolean.S_FALSE; 
  }
}
