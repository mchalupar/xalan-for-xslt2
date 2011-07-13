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
 * $Id: FuncSubstring.java 468655 2006-10-28 07:12:06Z minchau $
 */
package org.apache.xpath.functions.String;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.xpath.XPathContext;
import org.apache.xpath.functions.FunctionOneArg;
import org.apache.xpath.objects.XObject;
import org.apache.xpath.objects.XString;

/**
 * 
 * @author wangqi.aguai.2011@gmail.com @ Beijing China
 *
 */
public class FuncStringIriToUri extends FunctionOneArg
{
    static final long serialVersionUID = -5996676095024715502L;

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
	  try {
		return new XString(URLEncoder.encode(m_arg0.execute(xctxt).str(),"UTF-8"));
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
		return m_arg0.execute(xctxt);
	}
   
  }


}
